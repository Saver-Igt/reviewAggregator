import { createWebHistory, createRouter } from "vue-router";
import MainPage from '../pages/MainPage.vue'
import GamePage from '../pages/GamePage.vue'
import ReviewsPage from '../pages/ReviewsPage.vue'
import FAQPage from '../pages/FaqPage.vue'
import AllGamesPage from "@/pages/AllGamesPage.vue";
import Profile from "@/pages/Profile.vue";
import NotFound from "@/pages/NotFound.vue";
import registrationPage from "@/pages/RegistrationPage.vue";
import forbiddenPage from '@/pages/403page.vue';

const noAuthGuard = function (to, from, next){
    const isAuthorized = localStorage.getItem('token');
    if(isAuthorized) next({name: 'forbidden'});
    else next();
}
const authGuard = function (to, from, next){
    const isAuthorized = localStorage.getItem('token');
    if(!isAuthorized) next({name: 'forbidden'});
    else next();
}

const routes = [
    {
        path: '/',
        name: 'mainPage',
        component: MainPage
    },
    {
        path: '/403',
        name: 'forbidden',
        component: forbiddenPage
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
        component: ReviewsPage,
        beforeEnter: authGuard
    },
    {
        path: '/faq',
        name: 'FAQ',
        component: FAQPage
    },
    {
        path: '/profile',
        name: 'profile',
        component: Profile,
        beforeEnter: authGuard
    },
    {
        path: '/registration',
        name: 'registration',
        component: registrationPage,
        beforeEnter: noAuthGuard
    },
    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', component: NotFound }
]
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});

export default router;