<template>
  <div>
    <h2>Reviews</h2>
    <div>
      <template v-if="isReviewsEmpty">
        <div class="mt-5 mb-5 row">
          <div class="col-12 col-lg-5">
            <img src="../assets/empty.png" class="rounded img-fluid" width="450" height="300">
          </div>
         <div class="col-12 col-lg">
           <h3 class="mt-4 mb-lg-4">There doesn't seem to be any reviews here.</h3>
           <h4 class="mt-4 ">Write your review first!</h4>
         </div>
        </div>
      </template>
      <div v-else>
        <ul class="ps-0 mt-4" v-if="this.reviews">
          <li v-for="review in reviews" :key="review.userId">
            <div class="shadow rounded mb-4">
              <div class="card">
                <div class="card-body">
                  <div class="row">
                    <div class="col-4 col-lg-1">
                      <img src="https://media.istockphoto.com/id/1300845620/vector/user-icon-flat-isolated-on-white-background-user-symbol-vector-illustration.jpg?s=612x612&w=0&k=20&c=yBeyba0hUkh14_jgv1OKqIH0CCSWU_4ckRkAoy2p73o="
                           class="rounded-circle" style="width: 100px;"
                           alt="Avatar" />
                    </div>
                    <div class="col col-lg-2 mt-2">
                      <h4 class="card-title">{{review.user.firstName}} {{review.user.lastName}}</h4>
                      <div class="">Age: {{review.user.age}}</div>
                      <div class="">Gender: {{review.user.gender}}</div>
                    </div>
                    <div class="col col-lg mt-2">
                      <div class="badge bg-danger fs-5">{{review.score}}</div>
                      <p class="card-text fs-5">{{review.comment}}</p>
                    </div>
                  </div>
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
export default {
  name: 'vReviews',
  props:{
    gameId: Number,
  },
  computed:{
    reviews() {
      return this.$store.getters['reviewsModule/getReviewsByGameId'](this.gameId);
    },
    isReviewsEmpty(){
      if (this.reviews && this.reviews.length > 0){
        return false
      }else {
        return true
      }
    },
    colorScore(review){
      if(review.score > 8){
        return "bg-success"
      }else if(review.score < 2){
        return "bg-danger"
      }else{
        return "bg-warning"
      }
    }
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