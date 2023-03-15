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

        <h2>Your review</h2>
        <div class="mb-3">
          <label for="exampleFormControlInput1" class="form-label">Enter the score</label>
          <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="1,2,3,..." v-model="review.score">
        </div>
        <div class="mb-3">
          <label for="exampleFormControlInput2" class="form-label">Enter user id</label>
          <input type="number" class="form-control" id="exampleFormControlInput2" placeholder="1,2,3,..." v-model="review.userId">
        </div>
        <div class="mb-3 form-floating">
          <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" v-model="review.comment"></textarea>
          <label for="floatingTextarea">Comments</label>
        </div>
        <div>
          <button class="btn btn-success" @click="submit">
            Publish
          </button>
        </div>
      </section>
      <section>
        <Reviews v-bind:gameId = game.id />
      </section>
    </div>
  </div>
</template>

<script>
import Reviews from "@/components/Reviews.vue";
import {mapActions, mapGetters} from "vuex";
export default {
  name: 'GamePage',
  components:{
    Reviews
  },
  props: ['id'],
  data(){
    return{
      review:{
        userId:null,
        gameId:null,
        score:null,
        comment:null,
      }
    }
  },
  methods:{
    ...mapActions(['addReview']),
    submit: function () {
      this.review.gameId = this.id;
      this.addReview(this.review);
    }
  },
  computed:{
    ...mapGetters(['getGame']),
    game(){
      return this.$store.getters.getGame(parseInt(this.id))
    }
  }
}
</script>
<style scoped>
.col img{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
