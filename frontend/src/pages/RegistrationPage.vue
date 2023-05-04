<template>
    <div class="container-xxl mt-5 mb-5">
      <h1 class="mb-4">Registration</h1>
      <form v-on:submit.prevent="createNewUser">
        <div id="liveAlertPlaceholder"></div>
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="username" class="form-control"
                 name="username"
                 v-model="user.username"
                 required
                 @change=" onChange">
          <label class="text-danger">
            {{usernameErrorLabel}}
          </label>
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" name="password"
                 v-model="user.password" required>
        </div>
        <div class="mb-3">
          <label for="confPassword" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" name="confPassword"
                 v-model="user.confirmPassword" required  @change="comparisonPasswords">
          <label :class="{'text-danger': passwordError, 'text-success': !passwordError }">
            {{ passwordError ? 'Password mismatch' : 'Passwords match' }}</label>
        </div>

        <div class="col">
          <div class="mb-3">
            <label for="firstname" class="form-label">First name</label>
            <input type="text" class="form-control" name="firstname"
                   v-model="user.firstName">
            <label class="text-danger">{{firstNameErrorLabel}}</label>
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">Last name</label>
            <input type="text" class="form-control" name="lastName"
                   v-model="user.lastName">
            <label class="text-danger">{{lastNameErrorLabel}}</label>
          </div>
          <div class="mb-3">
            <label for="age" class="form-label">Age</label>
            <input type="number" class="form-control" name="age"
                   v-model="user.age">
            <label class="text-danger">{{ageErrorLabel}}</label>
          </div>
          <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <select class="form-select" id="validationCustom04" v-model="user.gender">
              <option value="Male">Male</option>
              <option value="Female">Female</option>
            </select>
            <label class="text-danger">{{genderErrorLabel}}</label>
          </div>
        </div>
        <div>
          <label class="text-danger" :class="{'d-none': abilityToSend}">
            *Please fill in all fields
          </label>
        </div>
        <div class="row">
          <div class="col mt-3">
            <button class="btn btn-primary" v-bind:disabled="!abilityToSend">Registration</button>
          </div>
        </div>
      </form>
    </div>
</template>
<script>
import axios from "axios";
export default {
  name: 'registrationPage',
  data(){
    return{
      canSendUser: false,
      passwordError: true,
      userNameError: true,
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
  computed:{
    usernameErrorLabel(){
      if(!this.user.username){
        return 'Please write your username';
      }else{
        return '';
      }
    },
    abilityToSend(){
      if(this.user.username && this.user.firstName && this.user.lastName && this.user.password && this.user.age && this.user.gender && this.user.confirmPassword && !this.passwordError){
        return true;
      }else{
        return false;
      }
    },
    firstNameErrorLabel(){
      if(!this.user.firstName){
        return 'Please write your firstName';
      }else{
        return '';
      }
    },
    lastNameErrorLabel(){
      if(!this.user.lastName){
        return 'Please write your lastName';
      }else{
        return '';
      }
    },
    ageErrorLabel(){
      if(!this.user.age){
        return 'Please write your age';
      }else{
        return '';
      }
    },
    genderErrorLabel(){
      if(!this.user.gender){
        return 'Please write your gender';
      }else{
        return '';
      }
    },
  },
  methods:{
    onChange(event) {
      console.log(event.target.value)
    },
    async createNewUser(){
        await axios.post('/api/registration',
            JSON.stringify(this.user), {
              headers:{'Content-Type': 'application/json; charset=utf-8'}
        })
          .then(response => {
            this.triggerAlert(response.data, 'success');
            this.$router.push({name:'mainPage'});
            console.log('Res: ', response.data);
          })
          .catch (error =>{
            console.error(error.response.data);
            this.triggerAlert(error.response.data, 'danger');
          })
    },
    comparisonPasswords(){
      if(this.user.password === this.user.confirmPassword){
        this.passwordError=false;
      }else{
        this.passwordError=true;
      }
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
<style>
</style>