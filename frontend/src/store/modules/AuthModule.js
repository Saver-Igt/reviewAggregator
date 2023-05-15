import {DefaultAPIInstance} from "@/AuthAPI";
export default {
    namespaced: true,
    state(){
        return {
            credentials:{
                userId: localStorage.getItem('id') || null,
                userRole: localStorage.getItem('role') || null,
                token: localStorage.getItem('token') || null,
                username: localStorage.getItem('username') || null
            }
        }
    },
    getters:{
        getUserId(state){
            return state.credentials.userId
        },
        getUsername(state){
            return state.credentials.username
        },
        getUserRole(state){
            return state.credentials.userRole
        }
    },
    mutations:{
        SET_USER_ID(state,id){
            state.credentials.userId = id;
            localStorage.setItem('id', id)
        },
        DELETE_USER_ID(state){
            state.credentials.userId = null;
            localStorage.removeItem('id');
        },
        SET_USER_ROLE(state,role){
          state.credentials.userRole = role;
          localStorage.setItem('role', role)
        },
        DELETE_USER_ROLE(state){
            state.credentials.userRole = null;
            localStorage.removeItem('role');
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
                commit('SET_USER_ROLE', res.data.userRole);
                commit('SET_USERNAME', res.data.username);
                commit('SET_USER_ID', res.data.id);
                DefaultAPIInstance.defaults.headers['authorization'] = `${res.data.token}`;
        },
        onLogout({commit}){
            commit('DELETE_USERNAME');
            commit('DELETE_TOKEN');
            commit('DELETE_USER_ROLE');
            commit('DELETE_USER_ID');
            delete DefaultAPIInstance.defaults.headers['authorization'];
        }
    }
}