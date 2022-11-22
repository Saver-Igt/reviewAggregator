const app = Vue.createApp({})
gamesComponent = {
  template: `<div v-if="loading">Loading...</div>
        <div v-else>
          <div class="table">
            <div class = "row" v-for="game in games">
              <div class = "icon">
                <img :src="game.iconURL" width="200" height="200" />
              </div>
              <div class = "name">
                {{ game.name}}
              </div>
              <div class = "rating">
                {{ game.avgRate}}
              </div>
            </div>
          </div>
        </div>`,
  data() {
    return {
        loading: true,
        games: null
    };
  },
  mounted() {
    axios
      .get('http://localhost:8080/games', {mode: 'no-cors'})
      .then(response => (this.games = response.data))
      .finally(() => this.loading = false);
  }
};
const routes = [
  {path: '/', component: gamesComponent},
  {path: '/games', component: gamesComponent},
]
const router = VueRouter.createRouter({
  history: VueRouter.createWebHashHistory(),
  routes,
})
app.component('button-counter', {
  data: function () {
    return {
      count: 0
    }
  },
  template: '<button v-on:click="count++">You clicked me {{ count }} times.</button>'
})

app.use(router)
app.mount('#app')
