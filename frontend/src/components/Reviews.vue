<template>
  <div>
    <h2>Reviews</h2>
    <div v-if="reviews">
      <ul id="example-1">
        <li v-for="review in reviews" :key="review.userId">
          User Name : {{review.user.username}}
          Score : {{review.score}}
          Comment :{{review.comment}}
        </li>
      </ul>
    </div>
    <div v-else>
      <p>There are not reviews yet. Be first!</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'vReviews',
  props:{
    gameId: Number,
  },
  data(){
    return{
      reviews :null
    }
  },
  mounted() {
    axios.get('/api/reviews/g' + this.gameId)
        .then(response => (this.reviews = response.data))
        .catch(error => console.log(error));
  }
}
</script>

<style>
</style>