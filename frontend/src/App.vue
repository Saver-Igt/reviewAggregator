<template>
  <div>
    <Header/>
    <router-view />
    <a href="#" class="btn btn-primary upp">
      <svg class="bi" width="32" height="32" fill="currentColor">
        <use xlink:href="./assets/bootstrap-icons.svg#arrow-up-square"/>
      </svg>
    </a>
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
.upp {
  position: sticky;
  bottom: 15px;
  left: 90%;
  right: 20%;
  transform: translatex(-5px);
  opacity: 1;
}
.upp:hover button {
  opacity: 1;
}
</style>
