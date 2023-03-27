<template>
  <div class="container-xxl">
      <section>
        <div class="row" v-if="username">
          <div class="col-3">
            <img src="https://media.istockphoto.com/id/1300845620/vector/user-icon-flat-isolated-on-white-background-user-symbol-vector-illustration.jpg?s=612x612&w=0&k=20&c=yBeyba0hUkh14_jgv1OKqIH0CCSWU_4ckRkAoy2p73o=" class="rounded-circle" style="width: 150px;"
                 alt="Avatar" />
          </div>
          <div class="col-3">
            <p>{{username}}</p>
          </div>
        </div>
      </section>
  </div>
</template>

<script>

export default {
  name: 'ProfilePage',
  components:{
  },
  props: ['id'],
  computed:{
    username(){
      return this.$store.getters['authModule/getUsername'];
    }
  }
}
</script>
<style>
</style>
