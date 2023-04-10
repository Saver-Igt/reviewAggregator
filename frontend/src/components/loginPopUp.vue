<template>
  <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h1 class="modal-title fs-5" id="exampleModalLabel">Login</h1>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Enter the Username</label>
            <input type="text" class="form-control" id="username"
                   v-model="user.username"
                   placeholder="username">
          </div>
          <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Enter the Password</label>
            <input type="password" class="form-control" id="password"
                   v-model="user.password"
                   placeholder="password">
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-primary"
                  data-bs-dismiss="modal"
                  data-bs-toggle="modal" data-bs-target="#confirmModal">Registration</button>
          <button type="button" class="btn btn-success"
                  data-bs-dismiss="modal" @click="login">Login</button>
        </div>
      </div>
    </div>
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
    login(){
      this.$store.dispatch(`authModule/onLogin`, {
        username: this.user.username,
        password: this.user.password
      }).then(() => {
        //this.$router.push({name: 'profile'})
      }).catch(error => {
        console.error(error)
      });
    }
  }
}
</script>
