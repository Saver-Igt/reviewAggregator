import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router';
import store from './store/index'

import 'bootstrap/dist/css/bootstrap.css'

import 'bootstrap/js/dist/carousel.js'
import 'bootstrap/js/dist/tab.js'
import 'bootstrap/js/dist/collapse.js'
import 'bootstrap/js/dist/dropdown'

createApp(App).use(router).use(store).mount('#app')
