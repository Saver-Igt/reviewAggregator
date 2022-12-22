<template>
  <div>
    <Header/>
    <router-view></router-view>
    <Footer/>
  </div>
</template>

<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'
export default {
  name: 'App',
  components: {
    Header,
    Footer
  }
}
</script>
<style>
:root{
  --color1: #1d2aa1;
  --color2: #a61919;
}
</style>
