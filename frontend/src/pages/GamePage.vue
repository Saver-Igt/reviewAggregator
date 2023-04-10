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
            <button class="btn btn-success" @click="publishReview">
              Publish
            </button>
          </div>
        </section>
        <section v-if="alreadyReviewed">
          <div class="mb-4 review-item" data-bs-toggle="modal" data-bs-target="#changeModal">
            <div class="card">
              <div class="card-body">
                <div class="row">
                  <div class="col-1 text-center mt-2">
                    <svg class="bi" width="75" height="75" fill="currentColor">
                      <use xlink:href="../assets/bootstrap-icons.svg#person-fill"/>
                    </svg>
                  </div>
                  <div class="col-10">
                    <h4 class="card-title"></h4>
                    <div class="fs-4  mb-2">Score: {{getReview.score}}</div>
                    <div class="fs-5 ">Comment: {{getReview.comment}}</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!--Change Modal -->
          <div class="modal fade" id="changeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="exampleModalLabel">Change</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">Enter the score</label>
                    <input type="number" class="form-control" id="exampleFormControlInput1" placeholder="1,2,3,..." v-model="review.score">
                  </div>
                  <div class="mb-3 form-floating">
                    <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" v-model="review.comment"></textarea>
                    <label for="floatingTextarea">Comments</label>
                  </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-danger"
                          data-bs-dismiss="modal"
                          data-bs-toggle="modal" data-bs-target="#confirmModal">Delete</button>
                  <button type="button" class="btn btn-primary" @click="changeReview" data-bs-dismiss="modal">Save changes</button>
                </div>
              </div>
            </div>
          </div>
          <!-- Confirm Modal -->
          <div class="modal fade" id="confirmModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h1 class="modal-title fs-5" id="exampleModalLabel">Delete Review</h1>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  Are you sure you want to delete the review?
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
                  <button type="button" class="btn btn-danger" @click="deleteReview" data-bs-dismiss="modal">Yes</button>
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
  watch:{

  },
  methods:{
    publishReview() {
      this.setGameAndUserId();
      this.$store.dispatch('reviewsModule/addReview', this.review);
    },
    setGameAndUserId: function(){
      this.review.userId = this.$store.getters['authModule/getUserId'];
      this.review.gameId = this.id;
    },
    changeReview(){
      this.setGameAndUserId();
      this.$store.dispatch('reviewsModule/changeReview', this.review);
      location.reload();
    },
    deleteReview(){
      this.setGameAndUserId();
      this.$store.dispatch('reviewsModule/deleteReview', this.review);
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
.review-item{
  border-radius:7px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  overflow: hidden;
  transition: all .3s;
  transform: scale(1);
  cursor: pointer;
}
.review-item:hover {
  transform: scale(1.05);
}
</style>
