<template>
  <div>
    <a href="#" class="btn btn-primary upp" id="myBtn">
      <svg class="bi" width="32" height="32" fill="currentColor">
        <use xlink:href="../assets/bootstrap-icons.svg#arrow-up-square"/>
      </svg>
    </a>
  </div>
</template>
<script>

export default {
  name: 'topDownButton',
}
</script>
<style>
:root{
  --color1: #1d2aa1;
  --color2: #a61919;
}
.upp {
  #display: none;
  position: fixed;
  z-index: 99;
  bottom: 20px;
  right: 30px;
  transform: translatex(-5px);
  opacity: 1;
}
.upp:hover button {
  opacity: 1;
}
</style>