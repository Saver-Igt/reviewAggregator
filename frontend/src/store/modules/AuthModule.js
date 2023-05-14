import {DefaultAPIInstance} from "@/AuthAPI";
export default {
    namespaced: true,
    state(){
        return {
            credentials:{
                userId: localStorage.getItem('id') || null,
                token: localStorage.getItem('token') || null,
                username: localStorage.getItem('username') || null
            }
        }
    },
    getters:{
        getUsername(state){
            return state.credentials.username
        },
        getUserId(state){
            return state.credentials.userId
        }
    },
    mutations:{
        SET_USER_ID(state,id){
          state.credentials.userId = id;
          localStorage.setItem('id', id)
        },
        DELETE_ID(state){
            state.credentials.userId = null;
            localStorage.removeItem('id');
        },
        SET_TOKEN(state, token){
            state.credentials.token = token;
            localStorage.setItem('token', token);
        },
        SET_USERNAME(state, username){
            state.credentials.username = username;
            localStorage.setItem('username', username);
        },
        DELETE_TOKEN(state){
            state.credentials.token = null;
            localStorage.removeItem('token');
        },
        DELETE_USERNAME(state){
            state.credentials.username = null;
            localStorage.removeItem('username');
        }
    },
    actions:{
        onLogin({commit}, {res}){
                commit('SET_TOKEN', res.data.token);
                commit('SET_USERNAME', res.data.username);
                commit('SET_USER_ID', res.data.userId);
                DefaultAPIInstance.defaults.headers['authorization'] = `${res.data.token}`;
        },
        onLogout({commit}){
            commit('DELETE_USERNAME');
            commit('DELETE_TOKEN');
            commit('DELETE_ID');
            delete DefaultAPIInstance.defaults.headers['authorization'];
        }
    }
}