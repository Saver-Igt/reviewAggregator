<template>
  <div>
    <Header/>
      <router-view />
    <top-down-button />
    <Footer/>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'
import topDownButton from "@/components/TopDownButton.vue";

export default {
  name: 'App',
  components: {
    Header,
    Footer,
    topDownButton
  },
  created() {
    this.$store.dispatch('gamesModule/loadGames');
    this.$store.dispatch('reviewsModule/loadReviews');
  }
}
</script>

<style>
</style>
