import axios from "axios";

export default {
    namespaced: true,
    state(){
        return{
            games: [],
        }
    },
    actions:{
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
    },
    mutations:{
        SET_GAMES(state, games){
            state.games = games
        }
    },
    getters:{
        getGames(state){return state.games},
        getSortedGames: (state) => [...state.games].sort((a, b) => { return (a.avgRate < b.avgRate) ? 1 : -1; }),
        getGame: (state) => (id) => {
            return state.games.find(game => game.id === id)
        }
    }
}