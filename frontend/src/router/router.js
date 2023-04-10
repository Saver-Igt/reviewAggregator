import { createWebHistory, createRouter } from "vue-router";
import MainPage from '../pages/MainPage.vue'
import GamePage from '../pages/GamePage.vue'
import ReviewsPage from '../pages/ReviewsPage.vue'
import FAQPage from '../pages/FaqPage.vue'
import AllGamesPage from "@/pages/AllGamesPage.vue";
import Profile from "@/pages/Profile.vue";
import NotFound from "@/pages/NotFound.vue";
import registrationPage from "@/pages/RegistrationPage.vue";
//import store from "@/store";

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
    {
        path: '/profile',
        name: 'profile',
        component: Profile
    },
    {
        path: '/registration',
        name: 'registration',
        component: registrationPage
    },

    // otherwise redirect to home
    { path: '/:pathMatch(.*)*', component: NotFound }
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
});
/*
router.beforeEach((to, from,next) => {
    if(!store.getters['authModule/getUserId'] && to.name==='games'){
        next({name: 'login'})
    }else {
        next();
    }
});

 */
export default router;