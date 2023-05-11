import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router';
import store from './store/index'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap'


createApp(App).use(router).use(store).mount('#app')
