import axios from "axios";

//Needless

export default {
    namespaced: true,
    state(){
        return{
            user:{
                userId: null,
                userName: null,
                firstName: null,
                lastName: null,
                role: null,
                age: null,
                gender: null
            }
        }
    },
    mutations:{
        SET_USER(state, user){
            state.user = user;
        },
    },
    actions:{
        async loadUser({commit}, userid){
            try {
                await axios.get('api/users/' + userid)
                    .then(response =>{
                        commit('SET_USER', response.data)
                    })
            }catch (error){
                console.error(error)
            }
        }
    },
    getters:{
        getUser(state){
            return state.user;
        }
    }
}