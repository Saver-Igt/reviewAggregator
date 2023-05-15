<template>
  <div>
    <div class="gamePage container-xxl" v-if="game">
        <div class="mt-5 row switchers rounded-top rounded-bottom">
          <div class="col text-center fs-2 pb-1"
               v-bind:class="[!displaySteamInfo ? 'act' : 'noAct']"
               @click="displaySteamInfo = false">
            Default
          </div>
          <div class="col text-center fs-2 pb-1"
               v-bind:class="[displaySteamInfo ? 'act' : 'noAct']"
               @click="loadSteamInfo(this.game.steam_appid)"
               v-bind:disabled="!game.steam_appid">
            <svg class="bi" width="32" height="32" v-bind:fill="[displaySteamInfo ? 'white' : 'black']">
              <use xlink:href="../assets/bootstrap-icons.svg#steam"/>
            </svg>Steam
          </div>
        <div class="gameInfo-border-wrap">
            <div class="gameInfo">
              <div v-if="!displaySteamInfo">
                <default-game :game="game"/>
              </div>
              <div v-if="displaySteamInfo">
                <steam-game :steam-data="steamInfo"/>
              </div>
            </div>
        </div>
        </div>
        <section>
          <h2>Your review</h2>
          <section v-if="isUserAuth && !alreadyReviewed">
            <form>
              <div class="mb-3">
                <label for="customRange1" class="form-label">Enter the score: {{review.score}}</label>
                <input type="range" class="form-range" id="customRange1" max="10" min="1" v-model="review.score">
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
            </form>
          </section>
          <section v-if="alreadyReviewed">
            <div class="mb-4 review-item" data-bs-toggle="modal" data-bs-target="#changeModal">
              <div class="card">
                <div class="card-body">
                  <div class="row">
                    <div class="col-4 col-lg-1 text-center mt-2">
                      <svg class="bi" width="75" height="75" fill="currentColor">
                        <use xlink:href="../assets/bootstrap-icons.svg#person-fill"/>
                      </svg>
                    </div>
                    <div class="col-8 col-lg-10">
                      <h4 class="card-title"></h4>
                      <div class="fs-4  mb-2">Score: {{getReview.score}}</div>
                      <div class="fs-5 ">Comment: {{getReview.comment}}</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </section>
          <section v-if="!isUserAuth">
            <log-in-pls />
          </section>
        </section>
        <section>
          <Reviews v-bind:gameId = game.id />
        </section>
    </div>
    <!--Change Modal -->
    <div class="modal fade" id="changeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="ChangeModalTitle">Change</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <div class="mb-3">
              <label for="customRange1" class="form-label">Enter the score: {{review.score}}</label>
              <input type="range" class="form-range" id="customRange1" max="10" min="1" v-model="review.score">
            </div>
            <div class="mb-3 form-floating">
              <textarea class="form-control" placeholder="Leave a comment here" id="floatingTextarea" v-model="review.comment"></textarea>
              <label for="floatingTextarea">Comment</label>
            </div>
          </div>
          <div class="modal-footer d-flex justify-content-between">
            <div>
              <button type="button" class="btn btn-danger" @click="deleteReview" data-bs-dismiss="modal">Delete</button>
            </div>
            <div>
              <button type="button" class="btn btn-primary" @click="changeReview" data-bs-dismiss="modal">Save changes</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import Reviews from "@/components/Reviews.vue";
import logInPls from "@/components/logInPls.vue";
import defaultGame from "@/pages/DefaultGame.vue";
import steamGame from "@/pages/SteamGame.vue";
import axios from "axios";
export default {
  name: 'GamePage',
  components:{
    Reviews,
    logInPls,
    defaultGame,
    steamGame
  },
  props: ['id'],
  data(){
    return{
      displaySteamInfo:false,
      steamInfo:{},
      review:{
        userId:null,
        gameId:null,
        score:null,
        comment:null,
      }
    }
  },
  methods:{
    async loadSteamInfo(appid){
        try {
          await axios.get('/api/steam/' + appid)
              .then(response =>{
                this.steamInfo = response.data;
                this.displaySteamInfo = true;
              })
        }catch (e){
          console.error(e)
        }
    },
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
      return this.$store.getters['gamesModule/getGame'](parseInt(this.id));
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
.gameInfo-border-wrap {
  border-radius: 0% 0% 1% 1%;
  position: relative;
  background: linear-gradient(to right,  var(--color1) 0%,var(--color2) 100%);
  padding: 4px;
}
.gameInfo {
  border-radius: 0% 0% 1% 1%;
  background: white;
  padding: 1.5rem;
}
.switchers{
  background: linear-gradient(to right,  var(--color1) 0%,var(--color2) 100%);
}
.act{
  background: transparent;
  color: white;
}
.noAct{
  background: white;
  color: black;
  cursor: pointer;
}
</style>
