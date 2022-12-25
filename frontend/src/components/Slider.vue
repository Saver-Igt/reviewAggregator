<template>
  <div class="slider">
    <div class="container-xxl">
      <h2 class="mb-4">{{title}}</h2>
      <button
          class="btn btn-primary arrow me-2"
          id="slide-left"
          @click="scrollLeft">
          <span aria-hidden="true">
              <svg class="bi" width="32" height="32" fill="black">
                  <use xlink:href="../assets/bootstrap-icons.svg#arrow-left"/>
              </svg>
          </span>
      </button>
      <button
          class="btn btn-primary arrow me-2"
          id="slide-right"
          @click="scrollRight">
          <span aria-hidden="true">
              <svg class="bi" width="32" height="32" fill="black">
                  <use xlink:href="../assets/bootstrap-icons.svg#arrow-right"/>
              </svg>
          </span>
      </button>
    </div>

    <div class="slide-container">
      <div class="slide-container" id="content" ref="content" v-if="games">
        <vSliderItem
            v-for="game in games"
            :key="game.id"
            :game_data="game"
        />
      </div>
    </div>
  </div>
</template>
<script>
import vSliderItem from './SliderItem.vue';
import axios from 'axios';
export default{
  name:'vSlider',
  components:{
    vSliderItem,
  },
  props: {
    title: String
  },
  data(){
    return{
      games: null
    }
  },
  methods: {
    scrollLeft: function () {
      const menu = this.$refs.content
      menu.scrollLeft -= 100;
    },
    scrollRight: function () {
      const menu = this.$refs.content
      menu.scrollLeft += 100;
    }
  },
  mounted() {
    axios.get('/api/games', {mode: 'no-cors'})
        .then(response => (this.games = response.data))
        .catch(error => console.log(error));
  }
}
</script>

<style>
.slide-container{
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
}
section .slide-container{
  width: 100%;
  margin: 0 auto;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-wrap: nowrap;
  overflow-x: auto;
  -webkit-overflow-scrolling: touch;
}
section .slide-container::-webkit-scrollbar{
  height: 10px;
  width: 2px;
}
section .slide-container::-webkit-scrollbar-track{
  --webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
}
section .slide-container::-webkit-scrollbar-thumb{
  outline: 1px solid #eee;
  background: var(--color1);
  background: -moz-linear-gradient(left,  var(--color1) 0%, var(--color2) 100%);
  background: -webkit-linear-gradient(left,  var(--color1) 0%,var(--color2) 100%);
  background: linear-gradient(to right,  var(--color1) 0%,var(--color2) 100%);
  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr=var(--color1), endColorstr=var(--color2),GradientType=1 );
}
</style>