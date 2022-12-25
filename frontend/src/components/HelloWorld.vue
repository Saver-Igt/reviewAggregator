<template>
  <div class="hello">
    <button class=”Search__button” @click="callRestService()">CALL Spring Boot REST backend service</button>

    <h3>{{ games }}</h3>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'HelloWorld',
  data(){
    return{
      games: null
    }
  },
  methods:{
    callRestService (){
      axios.get('/api/games/1')
          .then(response => (this.games = response.data))
          .catch(error => console.log(error));
    }
  }
}
</script>

<style scoped>
</style>
