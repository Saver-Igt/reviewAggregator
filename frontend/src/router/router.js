import { createWebHistory, createRouter } from "vue-router";
import MainPage from '../pages/MainPage.vue'
import GamePage from '../pages/GamePage.vue'
import ReviewsPage from '../pages/ReviewsPage.vue'
import FAQPage from '../pages/faqPage.vue'
import AllGamesPage from "@/pages/AllGamesPage.vue";

const routes = [
    {
        path: '/',
        name: 'mainPage',
        component: MainPage
    },
    {
        path: '/games',
        name: 'games',
        component: AllGamesPage
    },
    {
        path: '/games/:id',
        name: 'game',
        component: GamePage,
        props: true
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
    },

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', redirect: '/' }
]

const router = createRouter({
    // uris without hashes #
    history: createWebHistory(process.env.BASE_URL),
    routes
});
export default router;