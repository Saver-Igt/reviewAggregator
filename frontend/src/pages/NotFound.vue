<template>
  <div class="not-found container-xxl mt-5 mb-5 ">
    <img src="../assets/map.png" class="rounded mx-auto d-block img-fluid">
    <h1 class="head text-center fw-bold text-danger">404</h1>
    <h2 class="text-center fs-2 fw-bold">NOT FOUND</h2>
    <h3 class="text-center mb-3">Oops, looks like you've come to the wrong place.</h3>
    <div class="d-grid gap-2 col-6 mx-auto">
      <button class="btn btn-primary btn-lg" @click="this.$router.push({name:'mainPage'})">Go Home</button>
    </div>
  </div>
</template>
<script>
export default {
  name: 'notFound',
}
</script>
<style scoped>
.head{
  font-size: 6.7rem;
}
</style>