import { createStore } from 'vuex'
import axios from "axios";
import authModule from "@/store/modules/AuthModule";
export default createStore({
    modules:{
        authModule
    },
    state() {
        return {
            games: [],
            reviews:[]
        }
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
        SET_GAMES(state, games){
            state.games = games
        },
        SET_REVIEWS(state, reviews){
            state.reviews = reviews
        },
        ADD_REVIEW: (state, reviews) => {
            state.reviews.push(reviews);
        }
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