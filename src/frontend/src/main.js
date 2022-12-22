import { createApp } from 'vue'
import router from './router/router'
import App from './App.vue'


import 'bootstrap/dist/css/bootstrap.css'

import 'bootstrap/js/dist/carousel.js'
import 'bootstrap/js/dist/tab.js'
import 'bootstrap/js/dist/collapse.js'

const app = createApp(App)


app.use(router)
app.mount('#app')
