<template>
  <div class="container-xxl mt-5">
    <section>
      <form @submit="onSubmit">
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="username" class="form-control"
                 id="username" name="username"
                 v-model="user.username"
                 >
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" name="password"
                 v-model="user.password">
        </div>
        <div class="row">
          <div class="col">
            <button class="btn btn-primary">Submit</button>
          </div>
          <div class="col">
            <button class="btn btn-primary" @click="this.$router.push({name: 'registration'})">Registration</button>
          </div>
        </div>
      </form>
    </section>
  </div>
</template>
<script>
export default {
  data(){
    return{
      user:{
        username:null,
        password:null
      }
    }
  },
  methods: {
    onSubmit(){
      this.$store.dispatch(`authModule/onLogin`, {
        username: this.user.username,
        password: this.user.password
      }).then(() => {
        this.$router.push({name: 'profile'})
      }).catch(error => {
        console.error(error)
      });
    }
  }
}
</script>
<style>

</style>