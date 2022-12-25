<template>
  <div class="gamePage container-xxl">
    <h1>Hello Suka {{ id }}</h1>
    <div v-if="game">
      <section>
        <div class="row">
          <div class="col ">
            <img :src="require('../' + game.iconURL)"
                 width="700"
                 height="500"
                 class="img-fluid"/>
          </div>
          <div class="col">
            <h1>{{game.name}}</h1>
            <p>Average rating: {{game.avgRate}}</p>
            <p>{{game.description}}</p>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: 'GamePage',
  props: ['id'],
  data(){
    return{
      game:null
    }
  },
  mounted() {
    axios.get('/api/games/' + this.id, {mode: 'no-cors'})
        .then(response => (this.game = response.data))
        .catch(error => console.log(error));
  }
}
</script>
<style>
.col img{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
