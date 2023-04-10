import axios from "axios";

export default{
    namespaced:true,
    state(){
        return{
            reviews:[]
        }
    },
    actions:{
        async loadReviews({commit}){
            try {
                await axios.get('/api/reviews/')
                    .then(response => {
                        commit('SET_REVIEWS', response.data)
                    })
            }catch (error){
                console.error(error)
            }
        },
        async addReview({commit}, payload){
            try {
                await axios.post('/api/reviews/', JSON.stringify(payload), {
                    headers:{'Content-Type': 'application/json; charset=utf-8'}
                }).then(response => {
                    commit('ADD_REVIEW', payload)
                    console.log("Review added" + response);
                })
            }catch (error){
                console.error(error);
            }
        },
        async changeReview({commit}, review){
            try {
                await axios.put('/api/reviews/u' + parseInt(review.userId) + '/g' + parseInt(review.gameId),
                    JSON.stringify(review), {headers:{'Content-Type': 'application/json; charset=utf-8'}})
                    .then((response) => {
                        commit('UPDATE_REVIEW', response.data);
                        console.log('review change: ',response.data)
                    })
            }catch (error){
                console.error(error);
            }
        },
        async deleteReview({commit}, review){
            try {
                await axios.delete('/api/reviews/u' + parseInt(review.userId) + '/g' + parseInt(review.gameId))
                    .then((response) => {
                        commit('DELETE_REVIEW', review);
                        console.log('review deleted: ',response)
                    })
            }catch (error){
                console.error(error);
            }
        }
    },
    mutations:{
        SET_REVIEWS(state, reviews){
            state.reviews = reviews
        },
        ADD_REVIEW: (state, reviews) => {
            state.reviews.push(reviews);
        },
        UPDATE_REVIEW(state, payload){
            state.reviews = state.reviews.map(review => {
                if (review.userId === payload.userId && review.gameId === payload.gameId) {
                    return Object.assign({}, review, payload.data)
                }
                return review
            })
        },
        DELETE_REVIEW: (state, payload) =>{
            const index = state.reviews.findIndex(review => review.userId == payload.userId && review.gameId == payload.gameId);
            state.reviews.splice(index, 1);
        },
        ser(){}
    },
    getters:{
        getReviews(state){return state.reviews},
        getReviewsByGameId: (state) => (gameId)=>{
            return state.reviews.filter(review => review.gameId === gameId)
        },
        getReview: (state) => (gameId, userId) => {
            return state.reviews.find(review => review.gameId === gameId && review.userId === userId)
        },
        getReviewByUserId: (state) => (userId) =>{
            return state.reviews.filter(review => review.userId === userId);
        }
    }
}