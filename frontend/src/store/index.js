import { createStore } from 'vuex'
import axios from "axios";
export default createStore({
    state: {
        games: [],
        reviews: []
    },
    actions: {
        async loadGames({commit}){
            try {
                await axios.get('/api/games/')
                    .then(response => {
                        commit('SET_GAMES', response.data)
                    })
            }catch (error){
                console.error(error)
            }
        },
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
    mutations: {
        SET_GAMES(state, payload){
            state.games = payload
        },
        SET_REVIEWS(state, payload){
            state.reviews = payload
        },
        ADD_REVIEW: (state, payload) => {
            state.reviews.push(payload);
        },
    },
    getters:{
        getGames(state){return state.games},
        getSortedGames: (state) => [...state.games].sort((a, b) => { return (a.avgRate < b.avgRate) ? 1 : -1; }),
        getGame: (state) => (id) => {
            return state.games.find(game => game.id === id)
        },
        getReviews(state){return state.reviews},
        getReviewsByGameId: (state) => (gameId)=>{
            return state.reviews.filter(review => review.gameId ===gameId)
        }
    }
})