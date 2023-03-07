<template>
  <div>
    <h2>Reviews</h2>
    <div>
      <ul class="ps-0 mt-4" v-if="reviews">
        <li v-for="review in reviews" :key="review.userId">
          <div class="review-block shadow mb-4">
            <p class="userName ms-4 mt-2 mb-1">{{review.user.username}}</p>
            <div class="ms-4">
              <p class="mb-0 fst-italic">Score:</p>
              <div class="score text-success fw-bold mb-1">
                {{review.score}}
              </div>
              <p class="mb-0 fst-italic">Comment:</p>
              <div class="mb-2">
                {{review.comment}}
              </div>
            </div>
          </div>
        </li>
      </ul>
      <div v-if="reviews">
        <p>There are not reviews yet. Be first!</p>
      </div>
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
.review-block{
  border: 1px solid rgba(151, 161, 194, 0.79);
  border-radius: 10px;
}
.userName{
  font-size: 2rem;
  font-weight: 600;
}
.score{
  font-size: 1.5rem;
}
ul {
  margin-left: 0; /* Отступ слева в браузере IE и Opera */
  padding-left: 0; /* Отступ слева в браузере Firefox, Safari, Chrome */
}
li {
  list-style-type: none; /* Убираем маркеры */
}
</style>