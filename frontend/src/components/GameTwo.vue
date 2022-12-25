<template>
  <div class="gameTwo">
    <button class=”Search__button” @click="callRestService()">CALL Spring Boot REST backend service</button>

    <h3>{{ games }}</h3>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'GameTwo',
  data(){
    return{
      games: null
    }
  },
  methods:{
    callRestService (){
      axios.get('/api/games/2')
          .then(response => (this.games = response.data))
          .catch(error => console.log(error));
    }
  }
}
</script>

<style scoped>
</style>
