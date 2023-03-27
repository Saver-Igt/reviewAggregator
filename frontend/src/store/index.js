import { createStore } from 'vuex'
import authModule from "@/store/modules/AuthModule";
import reviewsModule from "@/store/modules/reviewsModule";
import gamesModule from "@/store/modules/gamesModule";
import userModule from "@/store/modules/userModule";
export default createStore({
    modules:{
        authModule,
        reviewsModule,
        gamesModule,
        userModule
    }
})