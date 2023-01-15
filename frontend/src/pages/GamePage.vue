<template>
  <div class="gamePage container-xxl">
    <div v-if="game">
      <section>
        <div class="row">
          <div class="col game_icon">
            <img :src="require('../' + game.iconURL)"
                 width="700"
                 height="500"
                 class="img-fluid"/>
          </div>
          <div class="col">
            <h2>{{game.name}}</h2>
            <p>Average rating: {{game.avgRate}}</p>
            <p>Description: </p>
            <p>{{game.description}}</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est, aut ea corporis nam porro, eum odit error
              nobis adipisci dolore in ullam sapiente ipsam ipsum pariatur nemo ratione corrupti culpa.</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est, aut ea corporis nam porro, eum odit error
              nobis adipisci dolore in ullam sapiente ipsam ipsum pariatur nemo ratione corrupti culpa.</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est, aut ea corporis nam porro, eum odit error
              nobis adipisci dolore in ullam sapiente ipsam ipsum pariatur nemo ratione corrupti culpa.</p>
            
          </div>
        </div>
      </section>
      <section>
        <h2>Reviews</h2>
        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label">Email address</label>
          <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="name@example.com">
        </div>
        <div class="mb-3 form-floating">
          <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea"></textarea>
          <label for="floatingTextarea">Comments</label>
        </div>
      </section>
      <section>
        <Reviews v-bind:gameId = game.id />
      </section>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Reviews from "@/components/Reviews.vue";
export default {
  name: 'GamePage',
  components:{
    Reviews
  },
  props: ['id'],
  data(){
    return{
      game:null
    }
  },
  mounted() {
    axios.get('/api/games/' + this.id)
        .then(response => (this.game = response.data))
        .catch(error => console.log(error));
  }
}
</script>
<style scoped>
.col img{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
