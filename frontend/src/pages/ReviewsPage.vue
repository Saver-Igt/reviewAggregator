<template>
  <div class="container-xxl" v-if="getReviews">
    <div v-if="getAuth">
      <div v-for="review in getReviews" :key="review.userId">
        <div class="shadow mb-3 mt-3 review-item" @click="openGamePage(review.gameId)">
          <div class="row">
            <div class="col-sm-4 mb-2 mt-2">
              <img :src="review.game.iconURL" height="200" class="shadow img-fluid"/>
            </div>
            <div class="col-sm-8">
              <h3 class="mt-3">{{review.game.name}}</h3>
              <h4 class="mt-3" :style="getColor(review)">score: {{review.score}}</h4>
              <h5>comment: {{review.comment}}</h5>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      <div class="container-xxl mt-5 mb-5">
        <div class="mb-2 mt-2">
        </div>
        <div>
          Pls login
        </div>
      </div>
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
    },
    getColor(review){
      if (review.score < 30){
        return "color: red";
      } else if (review.score > 75){
        return "color: green";
      }else {
        return "color: yellow";
      }
    },
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
