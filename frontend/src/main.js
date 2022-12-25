import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router';

import 'bootstrap/dist/css/bootstrap.css'

import 'bootstrap/js/dist/carousel.js'
import 'bootstrap/js/dist/tab.js'
import 'bootstrap/js/dist/collapse.js'

createApp(App).use(router).mount('#app')
