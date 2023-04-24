<template>
  <div>
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
                      data-bs-toggle="modal" data-bs-target="#confirmModal"
                      @click="this.$router.push({name: 'registration'})">Registration</button>
              <button type="submit" class="btn btn-success"
                      data-bs-dismiss="modal" @click="login">Login</button>
            </div>
        </div>
      </div>
    </div>
    <div class="toast-container position-fixed bottom-0 start-0 p-3">
      <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
          <img src="../assets/mem.jpg" width="50" height="50" class="rounded me-2" alt="...">
          <strong class="me-auto">Success!</strong>
          <small>just now</small>
          <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <div class="toast-body">
          Ah shit, here we go again ...
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {Toast} from "bootstrap";
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
        this.triggerToast();
      }).catch(error => {
        console.error(error)
      });
    },
    triggerToast(){
      const toastLiveExample = document.getElementById('liveToast')
      const toast = new Toast(toastLiveExample)
      toast.show()
    }
  }
}
</script>
