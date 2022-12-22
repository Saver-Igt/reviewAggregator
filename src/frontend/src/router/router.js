import { createWebHistory, createRouter } from "vue-router";
import MainPage from '../pages/MainPage.vue'
import GamePage from '../pages/GamePage.vue'
import ReviewsPage from '../pages/ReviewsPage.vue'
import FAQPage from '../pages/faqPage.vue'

const routes = [
    {
        path: '/',
        name: 'mainPage',
        component: MainPage
    },
    {
        path: '/games',
        name: 'games',
        component: GamePage
    },
    {
        path: '/reviews',
        name: 'reviews',
        component: ReviewsPage
    },
    {
        path: '/faq',
        name: 'FAQ',
        component: FAQPage
    }
]
const router = createRouter({
    mode: 'history',
    history: createWebHistory(),
    routes,
})

export default router;