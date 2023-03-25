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
                  <div class="row">
                    <div class="col-1">
                      <img src="https://media.istockphoto.com/id/1300845620/vector/user-icon-flat-isolated-on-white-background-user-symbol-vector-illustration.jpg?s=612x612&w=0&k=20&c=yBeyba0hUkh14_jgv1OKqIH0CCSWU_4ckRkAoy2p73o="
                           class="rounded-circle" style="width: 100px;"
                           alt="Avatar" />
                    </div>
                    <div class="col-2 mt-2">
                      <h4 class="card-title">{{review.user.firstName}} {{review.user.lastName}}</h4>
                      <div class="">Age: {{review.user.age}}</div>
                      <div class="">Gender: {{review.user.gender}}</div>
                    </div>
                    <div class="col mt-2">
                      <div class="badge bg-primary fs-5">{{review.score}}</div>
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
import {mapGetters} from "vuex";
export default {
  name: 'vReviews',
  props:{
    gameId: Number,
  },
  data(){
    return{
    }
  },
  methods:{
  },
  computed:{
    ...mapGetters(['getReviewsByGameId']),
    reviews() {
      return this.getReviewsByGameId(parseInt(this.gameId))
    },
    isReviewsEmpty(){
      if (this.reviews && this.reviews.length > 0){
        return false
      }else {
        return true
      }
    }
  },
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