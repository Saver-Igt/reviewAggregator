<template>
  <div class="container-xxl">
    <h2>Hello</h2>
    <p>{{game.name}}</p>
    <p>{{game.type}}</p>
    <p>{{game.requiredAge}}</p>
    <p>{{game.controllerSupport}}</p>
    <p>{{game.detailedDescription}}</p>
    <p>{{game.supportedLanguages}}</p>
    <p>{{game.free}}</p>
  </div>
</template>
<script>
import axios from "axios";

export default {
  data(){
    return{
      game: null,
    }
  },
  created() {
    this.loadinfo()
  },
  methods:{
    async loadinfo(){
      try{
        await axios.get('/api/steam').then(response =>{
          this.game = response.data;
        })
      }catch (error){
        console.error(error);
      }
    },

  },
}
</script>
<style>

</style>