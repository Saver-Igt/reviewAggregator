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
        <section v-if="isUserAuth && !alreadyReviewed">
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Enter the score</label>
            <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="1,2,3,..." v-model="review.score">
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
        <section v-if="alreadyReviewed">
          <div class="shadow mb-4">
            <div class="card">
              <div class="card-body">
                <div class="row">
                  <div class="col-1 text-center">
                    <svg class="bi" width="75" height="75" fill="currentColor">
                      <use xlink:href="../assets/bootstrap-icons.svg#person-fill"/>
                    </svg>
                    <div class="">{{username}}</div>
                  </div>
                  <div class="col-10">
                    <h4 class="card-title"></h4>
                    <div class="fs-4 fw-bold mb-2">Score: {{getReview.score}}</div>
                    <div class="fs-5 fw-bold">Comment: {{getReview.comment}}</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
        <section v-if="!isUserAuth">
          login pls
        </section>
      </section>
      <section>
        <Reviews v-bind:gameId = game.id />
      </section>
    </div>
  </div>
</template>

<script>
import Reviews from "@/components/Reviews.vue";
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
    submit: function () {
      this.setGameAndUserId();
      this.$store.dispatch('reviewsModule/addReview', this.review)
    },
    setGameAndUserId: function(){
      this.review.userId = this.$store.getters['authModule/getUserId'];
      this.review.gameId = this.id;
    }
  },
  computed:{
    game(){
      return this.$store.getters['gamesModule/getGame'](parseInt(this.id))
    },
    isUserAuth(){
      if(this.$store.getters['authModule/getUsername']){
        return true;
      }else{
        return false;
      }
    },
    getReview(){
      return this.$store.getters['reviewsModule/getReview'](parseInt(this.review.gameId), parseInt(this.review.userId));
    },
    username(){
      return this.$store.getters['authModule/getUsername'];
    },
    userId(){
      return this.$store.getters['authModule/getUserId']
    },
    alreadyReviewed(){
      this.setGameAndUserId();
      if(this.review.gameId && this.review.userId){
        if(this.getReview){
          return true;
        }
        return false;
      }else{
        return false;
      }
    }
  }
}
</script>
<style scoped>
.col img{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
