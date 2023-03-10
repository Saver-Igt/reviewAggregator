<template>
  <div>
    <h2>Reviews</h2>
    <div>
      <template v-if="isReviewsEmpty">
        <p>There are not reviews yet. Be first!</p>
      </template>
      <div v-else>
        <ul class="ps-0 mt-4" v-if="this.reviews">
          <li v-for="review in reviews" :key="review.userId">
            <div class="shadow mb-4">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">{{review.user.username}}</h4>
                  <div class="badge bg-primary">{{review.score}}</div>
                  <p class="card-text">{{review.comment}}</p>
                </div>
              </div>
            </div>
          </li>
        </ul>
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
      reviews :null,
      isReviewsEmpty: true
    }
  },
  methods:{
    checkEmpty(){
      if (this.reviews && this.reviews.length > 0){
        this.isReviewsEmpty = false
      }else {
        this.isReviewsEmpty = true
      }
    }
  },
  mounted() {
    axios.get('/api/reviews/g' + this.gameId)
        .then(response => {
          this.reviews = response.data;
          this.checkEmpty()
        }).catch(error => {
          console.log(error)
        });
  }
}
</script>
<style>
ul {
  margin-left: 0; /* Отступ слева в браузере IE и Opera */
  padding-left: 0; /* Отступ слева в браузере Firefox, Safari, Chrome */
}
li {
  list-style-type: none; /* Убираем маркеры */
}
</style>