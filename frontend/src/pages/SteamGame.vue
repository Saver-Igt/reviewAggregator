<template>
  <div>
    <div v-if="steamData.success">
      <div class="row mt-4 ms-3">
        <div class="col-sm-4">
          <img :src="steamData.data.header_image" class="img-fluid">
        </div>
        <div class="col-sm-8">
          <h2>{{steamData.data.name}}</h2>
          <h5>Type: {{steamData.data.type}}</h5>
          <h5>Required age: {{steamData.data.required_age}}</h5>
            <h4>Price:
              <div v-if="!steamData.data.is_free" v-html="steamData.data.price_overview.final_formatted"></div>
              <div v-else>Free</div>
            </h4>
          <p v-if="steamData.data.website">website: <a :href="steamData.data.website" target="_blank">{{steamData.data.website}}</a></p>
        </div>
      </div>
      <div class="row ms-4">
        <section class="ps-0">
          <slider title="Screenshots" sliderType="screenshots" :data="steamData.data.screenshots"/>
        </section>
        <h4 class="mt-3 ps-0">Description:</h4>
        <div class="ps-0" id="dsc" v-html="steamData.data.detailed_description"></div>
        <div>
          <h4 class="mt-3">Supported languages:</h4>
          <div v-html="steamData.data.supported_languages"></div>
        </div>
        <h4 class="mt-3">PC Requirements: </h4>
        <div class="row">
          <div v-html="steamData.data.pc_requirements.minimum" class="col"></div>
          <div v-html="steamData.data.pc_requirements.recommended" class="col"></div>
        </div>
        <div>
          <h4 class="mt-3">Developers:</h4>
          <div v-html="steamData.data.developers"></div>
        </div>
        <div>
          <h4 class="mt-3">Publishers:</h4>
          <div v-html="steamData.data.publishers"></div>
        </div>
      </div>
    </div>

    <div v-else class="row">
      <img src="../assets/shit_corporation.png" class="img-fluid">
    </div>
  </div>
</template>
<script>
import slider from "@/components/Slider.vue";
export default {
  components:{
    slider
  },
  mounted() {
    if(this.steamData.success){
      const myElement = document.getElementById("dsc");
      const imgs = myElement.getElementsByTagName('img');
      const links = myElement.getElementsByTagName('a');
      [...imgs].forEach((img) => {
        img.classList.add("img-fluid");
      });

      [...links].forEach((link) => {
        link.classList.add("textOverflow");
      });
    }
  },
  props:['steamData'],
}
</script>
<style>
.textOverflow{
  word-wrap:break-word;
}
</style>