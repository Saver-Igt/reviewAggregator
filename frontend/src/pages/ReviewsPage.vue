<template>
  <div class="container-xxl" v-if="getReviews">
    <div v-if="getAuth">
      <h1 class="mt-5">There are your reviews</h1>
      <div v-for="review in getReviews" :key="review.userId">
        <div class="row shadow mb-3 mt-3 review-item" @click="openGamePage(review.gameId)">
          <div class="col-3 mb-2 mt-2">
            <img :src="require('../' + review.game.iconURL)" width="300" height="200" class="shadow"/>
          </div>
          <div class="col">
            <h4 class="mt-3">{{review.game.name}}</h4>
            <h5 class="mt-3">score: {{review.score}}</h5>
            <h5>comment: {{review.comment}}</h5>
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      Pls login
    </div>
  </div>
</template>
<script>
export default {
  name: 'ReviewsPage',
  computed:{
    getReviews(){
      return this.$store.getters['reviewsModule/getReviewByUserId'](parseInt(this.$store.getters['authModule/getUserId']));
    },
    getAuth(){
      return this.$store.getters['authModule/getUserId'];
    }
  },
  methods:{
    openGamePage(gameId){
      this.$router.push({
        name: 'game',
        params: {id: gameId}
      });
    }
  }
}
</script>
<style scoped>
.review-item{
  overflow: hidden;
  transition: all .3s;
  transform: scale(.95);
  cursor: pointer;
}
.review-item:hover {
  transform: scale(1);
}
</style>
