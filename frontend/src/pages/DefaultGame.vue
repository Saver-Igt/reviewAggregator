<template>
  <div>
    <div class="gamePage container-xxl">
      <div v-if="game">
        <section>
          <div class="row">
            <div class="col-sm-4 game_icon">
              <img :src="require('../' + game.iconURL)"
                   width="700"
                   height="500"
                   class="img-fluid mb-5"
              />
            </div>
            <div class="col-sm-8">
              <h2 class="mt-5 mt-lg-0">{{game.name}}</h2>
              <p>Average rating: {{game.avgRate}}</p>
              <p>Description: </p>
              <p>{{game.description}}</p>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est, aut ea corporis nam porro, eum odit error
                nobis adipisci dolore in ullam sapiente ipsam ipsum pariatur nemo ratione corrupti culpa.</p>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est, aut ea corporis nam porro, eum odit error
                nobis adipisci dolore in ullam sapiente ipsam ipsum pariatur nemo ratione corrupti culpa.</p>
              <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est, aut ea corporis nam porro, eum odit error
                nobis adipisci dolore in ullam sapiente ipsam ipsum pariatur nemo ratione corrupti culpa.</p>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  props: ['game'],
}
</script>
<style scoped>
.col img{
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>
