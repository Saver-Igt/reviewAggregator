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
                console.error(error)
            }
        }
    },
    mutations:{
        SET_REVIEWS(state, reviews){
            state.reviews = reviews
        },
        ADD_REVIEW: (state, reviews) => {
            state.reviews.push(reviews);
        }
    },
    getters:{
        getReviews(state){return state.reviews},
        getReviewsByGameId: (state) => (gameId)=>{
            return state.reviews.filter(review => review.gameId === gameId)
        },
        getReview: (state) => (gameId, userId) => {
            return state.reviews.find(review => review.gameId === gameId && review.userId === userId)
        }
    }
}