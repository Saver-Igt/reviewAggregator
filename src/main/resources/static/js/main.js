productsComponent = {
  template: `<div v-if="loading">Loading...</div>
        <div v-else>
          <div class="table">
            <div class = "row" v-for="product in products">
              <div class = "r-1" >
                {{ product.name}}
              </div>
              <div class = "r-2">
                {{ product.description}}
              </div>
            </div>
          </div>
        </div>`,
  data() {
    return {
        loading: true,
        products: null
    };
  },
  mounted() {
    axios
      .get('http://localhost:8080/products', {mode: 'no-cors'})
      .then(response => (this.products = response.data))
      .finally(() => this.loading = false);
  }
};
const routes = [
  {path: '/', component: productsComponent},
  {path: '/products', component: productsComponent},
]
const router = VueRouter.createRouter({
  history: VueRouter.createWebHashHistory(),
  routes,
})

const app = Vue.createApp({})

app.use(router)
app.mount('#app')