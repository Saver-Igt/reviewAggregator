import axios from "axios";

const loginConfig = {
    baseURL: process.env.VUE_APP_BASE_URL,
    headers:{
        'Content-Type': 'application/json; charset=utf-8',
    }
}
export const LoginAPIInstance = axios.create(loginConfig);

let defaultConfig = {
    baseURL: process.env.VUE_APP_BASE_URL,
    headers:{
        'Content-Type': 'application/json; charset=utf-8',
    }
}
const token = localStorage.getItem('token');
if (token) defaultConfig.headers['authorization'] = `${token}`;
export const DefaultAPIInstance = axios.create(defaultConfig);