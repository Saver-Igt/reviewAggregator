<template>
  <div class="helloWorld">
    <h1>{{msg}}</h1>
    <div v-if="games">
      <p>{{games[1].name}}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'HelloWorld',
  data(){
    return{
      msg: '',
      games: null
    }
  },
  mounted() {
    fetch("/api/hello")
        .then((response) => response.text())
        .then((data) => {
          this.msg = data;
        });
    axios.get('/api/games', {mode: 'no-cors'})
        .then(response => (this.games = response.data))
        .catch(error => console.log(error));
  }
}
</script>
