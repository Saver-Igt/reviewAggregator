<template>
  <div class="allGamesPage container-xxl">
    <section>
      <h1 class="mb-4 ms-3">All games</h1>
      <div class="row">
        <div class="col-sm-4 mb-4" v-for="game in games" :key="game.Id">
          <div class="card">
            <img :src="require('../' + game.iconURL)"
                 width="700"
                 height="500"
                 class="img-fluid"/>
            <div class="card-body">
              <h5 class="card-title mb-4 gameName">{{game.name}}</h5>
              <p>{{game.avgRate}}</p>
              <a href="" class="btn btn-primary" @click="redirectToGamePage(game.id)">Go</a>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'AllGamesPage',
  data(){
    return{
      games:null
    }
  },
  methods:{
    redirectToGamePage(id){
      this.$router.push({
        name: 'game',
        params: {id: id}
      })
    }
  },
  mounted() {
    axios.get('/api/games/')
        .then(response => (this.games = response.data))
        .catch(error => console.log(error));
  }
}
</script>
<style>
.gameName{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
