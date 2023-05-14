<template>
  <div>
    <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
          <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Login</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close" id="close"></button>
          </div>
          <form onsubmit="return false">
            <div class="modal-body">
              <div id="liveAlertPlaceholder"></div>
              <div class="mb-3">
                <label for="username" class="form-label">Enter the Username</label>
                <input type="text" class="form-control" id="username"
                       v-model="user.username"
                       placeholder="username"
                       required
                >
              </div>
              <div class="mb-3">
                <label for="password" class="form-label">Enter the Password</label>
                <input type="password" class="form-control" id="password"
                       v-model="user.password"
                       placeholder="password"
                       required
                >
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-primary"
                      data-bs-dismiss="modal"
                      @click="this.$router.push({name: 'registration'})">Registration</button>
              <button type="submit" class="btn btn-success"
                       @click="login" v-bind:disabled="checkInputs">Login</button>
              <input type="submit" hidden />
            </div>
          </form>
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
import {AuthAPI} from "@/index";
export default {
  data(){
    return{
      user:{
        username:null,
        password:null
      }
    }
  },
  computed:{
    checkInputs(){
      if(!this.user.username || !this.user.password){
        return true;
      }
      return false;
    }
  },
  methods: {
    login(){
      AuthAPI.login(this.user.username,this.user.password).then((res) => {
        this.$store.dispatch(`authModule/onLogin`, {res});
        document.getElementById('close').click();
        this.triggerToast();
      }).catch(e => {
        this.triggerAlert(e.response.data, 'danger');
        console.error('Error: ', e);
      })
    },
    triggerToast(){
        const toastLiveExample = document.getElementById('liveToast')
        const toast = new Toast(toastLiveExample);
        toast.show();
    },
    triggerAlert(message, type){
      const alertPlaceholder = document.getElementById('liveAlertPlaceholder')

      const alert = (message, type) => {
        const wrapper = document.createElement('div')
        wrapper.innerHTML = [
          `<div class="alert alert-${type} alert-dismissible" role="alert">`,
          `   <div>${message}</div>`,
          '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
          '</div>'
        ].join('')

        alertPlaceholder.append(wrapper)
      }
      alert(message, type);
    }
  }
}
</script>
