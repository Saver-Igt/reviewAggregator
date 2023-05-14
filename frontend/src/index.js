import {LoginAPIInstance, DefaultAPIInstance} from "@/AuthAPI";

export const AuthAPI ={
    login(username, password){
        const url = '/api/auth/login';
        const data = {username, password}
        return LoginAPIInstance.post(url, data);
    },
    logout(){
        const url = '/api/auth/logout';
        return DefaultAPIInstance.post(url);
    },
    getUserInfo(id){
        const url = '/api/users/'+id;
        return DefaultAPIInstance.get(url);
    }
}