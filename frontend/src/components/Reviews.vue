<template>
  <div>
    <h2>There are many reviews!</h2>
    <ul id="example-1">
      <li v-for="review in reviews" :key="review.userId">
        userID : {{review.userId}}
        Score : {{review.value}}
        Comment :{{review.comment}}
      </li>
    </ul>
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