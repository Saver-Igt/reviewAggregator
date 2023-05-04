<template>
  <div class="layout">
    <div class="module-border-wrap">
      <div class="module">
        <h4>You must be logged in to leave your review</h4>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name:'logInPls',

}
</script>
<style scoped>
.module-border-wrap {
  padding: 1rem;
  border-radius: 15px;
  position: relative;
  background: linear-gradient(to right,  var(--color1) 0%,var(--color2) 100%);
  padding: 3px;
}
.module {
  border-radius: 14px;
  background: white;
  padding: 2rem;
}
</style>