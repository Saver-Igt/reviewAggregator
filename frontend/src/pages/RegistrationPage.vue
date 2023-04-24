<template>
  <div class="">
    <div class="container-xxl mt-5 mb-5">
      <h1 class="mb-4">Registration</h1>
      <form v-on:submit.prevent="createNewUser">
        <div id="liveAlertPlaceholder"></div>
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="username" class="form-control"
                 name="username"
                 v-model="user.username">
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" name="password"
                 v-model="user.password">
        </div>
        <div class="mb-3">
          <label for="confPassword" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" name="confPassword"
                 v-model="user.confirmPassword">
        </div>
        <div class="mb-3">
          <label for="firstname" class="form-label">First name</label>
          <input type="text" class="form-control" name="firstname"
                 v-model="user.firstName">
        </div>
        <div class="mb-3">
          <label for="lastName" class="form-label">Last name</label>
          <input type="text" class="form-control" name="lastName"
                 v-model="user.lastName">
        </div>
        <div class="mb-3">
          <label for="age" class="form-label">Age</label>
          <input type="text" class="form-control" name="age"
                 v-model="user.age">
        </div>
        <div class="mb-3">
          <label for="gender" class="form-label">Gender</label>
          <input type="text" class="form-control" name="gender"
                 v-model="user.gender">
        </div>
        <div class="row">
          <div class="col mt-3">
            <button class="btn btn-primary">Registration</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>
<script>
import axios from "axios";

export default {
  name: 'registrationPage',
  data(){
    return{
      user:{
        username:null,
        password:null,
        confirmPassword:null,
        firstName: null,
        lastName: null,
        age:null,
        gender:null
      }
    }
  },
  methods:{
    async createNewUser(){
        await axios.post('/api/registration',
            JSON.stringify(this.user), {
              headers:{'Content-Type': 'application/json; charset=utf-8'}
        })
          .then(response => {
            console.log('Res: ', response.data);
          })
          .catch (error =>{
            console.error(error.response.data);
            this.triggerError(error.response.data);
          })
    },
    triggerError(errorMessage){
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
      alert(errorMessage, 'danger');
    }
  }
}
</script>
<style>

</style>