<template>
  <div class="v-mainPage">
    <section>
      <Carusel/>
    </section>
    <div class="container-xxl">
      <section>
        <Slider title="Best games" sliderType="gameData" :data="sortedGames"/>
      </section>
    </div>
  </div>
</template>

<script>
import Carusel from "@/components/Carusel.vue";
import Slider from "@/components/Slider.vue";
export default{
  name:'mainPage',
  components:{
    Carusel,
    Slider
  },
  computed:{
    sortedGames() {
      return this.$store.getters['gamesModule/getSortedGames']
    }
  }
}
</script>
<style>
  section{
    padding-top: 50px;
    padding-bottom: 50px;
  }
</style>