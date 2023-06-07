<template>
  <div class="allGamesPage container-xxl">
    <section v-if="games">
      <h1 class="mb-4 ms-3">All games</h1>
      <div class="row">
        <div class="col-sm-4 mb-4" v-for="game in games" :key="game.Id">
          <div class="card">
            <img :src="game.iconURL"
                 class="img-fluid icon_url"/>
            <div class="card-body">
              <h5 class="card-title gameName">{{game.name}}</h5>
              <h5 class="card-body">Average rating: {{game.avgRate}}</h5>
              <a href="" class="btn btn-primary" @click="redirectToGamePage(game.id)">Go</a>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'AllGamesPage',
  data(){
    return{

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
  computed:{
    games(){
      return this.$store.getters['gamesModule/getGames']
    }
  },
}
</script>
<style>
.gameName{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
.icon_url{
  object-fit: cover;
}
</style>