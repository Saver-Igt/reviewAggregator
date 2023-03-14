<template>
  <div class="slider">
    <div class="container-xxl">
      <h2 class="mb-4">{{title}}</h2>
      <button
          class="btn btn-primary arrow me-2"
          id="slide-left"
          @click="swipeLeft">
          <span aria-hidden="true">
              <svg class="bi" width="32" height="32" fill="black">
                  <use xlink:href="../assets/bootstrap-icons.svg#arrow-left"/>
              </svg>
          </span>
      </button>
      <button
          class="btn btn-primary arrow me-2"
          id="slide-right"
          @click="swipeRight">
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
            v-for="game in sortedGames"
            :key="game.id"
            :game_data="game"
        />
      </div>
    </div>
  </div>
</template>
<script>
import vSliderItem from './SliderItem.vue';
import {mapGetters} from "vuex";
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
    }
  },
  methods: {
    /**
     * scrollTo - Horizontal Scrolling
     * @param {(HTMLElement ref)} element - Scroll Container
     * @param {number} scrollPixels - pixel to scroll
     * @param {number} duration -  Duration of scrolling animation in millisec
     */
    scrollTo(element, scrollPixels, duration) {
      const scrollPos = element.scrollLeft;
      // Condition to check if scrolling is required
      var getTotal;
      if ( !( (scrollPos === 0 || scrollPixels > 0) && (element.clientWidth + scrollPos === element.scrollWidth || scrollPixels < 0)))
      {
        // Get the start timestamp
        const startTime =
            "now" in window.performance
                ? performance.now()
                : new Date().getTime();

        getTotal = function (timestamp) {
          //Calculate the timeelapsed
          const timeElapsed = timestamp - startTime;
          //Calculate progress
          const progress = Math.min(timeElapsed / duration, 1);
          //Set the scrolleft
          element.scrollLeft = scrollPos + scrollPixels * progress;
          //Check if elapsed time is less then duration then call the requestAnimation, otherwise exit
          if (timeElapsed < duration) {
            //Request for animation
            window.requestAnimationFrame(getTotal);
          } else {
            return;
          }
        }
        //Call requestAnimationFrame on scroll function first time
        window.requestAnimationFrame(getTotal);
      }
    },
    swipeLeft() {
      const content = this.$refs.content;
      this.scrollTo(content, -310, 800);
    },
    swipeRight() {
      const content = this.$refs.content;
      this.scrollTo(content, 310, 800);
    }
  },
  computed:{
    ...mapGetters(['getGames', 'getSortedGames']),
    sortedGames() {
      return this.getSortedGames;
    },
    games(){
      return this.getGames;
    }
  },
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