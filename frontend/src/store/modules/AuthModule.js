import {AuthAPI} from "@/index";
import {DefaultAPIInstance} from "@/AuthAPI";

export default {
    namespaced: true,
    state(){
        return {
            credentials:{
                token: localStorage.getItem('token') || null,
                username: localStorage.getItem('username') || null
            }
        }
    },

    getters:{
        getUsername: (state) => state.credentials.username,
    },

    mutations:{
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
        onLogin({commit}, {username, password}){
            AuthAPI.login(username,password).then((res) => {
                    console.log('res ', res.data)
                    commit('SET_TOKEN', res.data.token);
                    commit('SET_USERNAME', res.data.username);
                    DefaultAPIInstance.defaults.headers['authorization'] = `Bearer ${res.token}`;
                })
        },
        onLogout({commit}){
            commit('DELETE_USERNAME');
            commit('DELETE_TOKEN');
            delete DefaultAPIInstance.defaults.headers['authorization'];
        }
    }
}