<template>
  <div class="slider-item">
    <a href="" class="game_card_icon" @click="redirectToGamePage">
      <div>
        <img :src="require('../' + game_data.iconURL)" width="200" height="200" />
      </div>
    </a>
    <div class = "game-card-details">
      <h2 :title=game_data.name>
        {{ game_data.name}}
      </h2>
      <p class = "avg-rating">
        {{ game_data.avgRate}}
      </p>
    </div>

  </div>
</template>

<script>
export default{
  name: 'vGameCard',
  props:{
    game_data:{
      type: Object,
      default(){
        return{}
      }
    }
  },
  methods:{
    redirectToGamePage(){
      this.$router.push({
        name: 'game',
        params: {id: this.game_data.id}
      })
    }
  }
}
</script>

<style>
.slider-item{
  width: 300px;
  flex: 0 0 auto;
  object-fit: cover;
  cursor: pointer;
  margin: 5px;
  overflow: hidden;
  transform: scale(.95);
  transition: all .3s;
}
.slider-item:hover {
  transform: scale(1);
}
.game_card_icon img{
  border-radius: 8px;
  width: 300px;
  height: 200px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
a div{
  border-radius: 8px;
  background: #000;  /* У блока, оборачивающего картинку при наведении будет просвечивать черный фон */
  overflow: hidden;  /* Ограничиваем видиую область */
}
a div img{
  opacity: 1;
  transition: opacity 124ms linear, transform 124ms linear;  /* Плавное изменение прозрачности и увеличения */

  height: auto;
  display: block; /* Убираем полосу под картинкий */
}
a:hover div img{
  opacity: 0.9; /* Высветляем картинку, но она становится темнее, так как под ней черный фон */
  transform: scale(1.05); /* Увеличение картинки */
}
.game-card-details h2 {
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
  margin-bottom: 0;
  margin-top: 0.5rem;
  font-size: 2rem;
  font-weight: 600;
}
.game-card-details p{
  font-size: 1.6rem;
  font-weight: 700;
  color: green;
}
</style>