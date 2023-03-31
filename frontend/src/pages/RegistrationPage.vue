<template>
  <div class="container-xxl">
    <div class="mt-5 mb-5">
      <h1 class="mb-4">Registration</h1>
      <form>
        <div class="mb-3">
          <label for="username" class="form-label">Username</label>
          <input type="username" class="form-control"
                 id="username" name="username"
                 v-model="user.username">
        </div>
        <div class="mb-3">
          <label for="password" class="form-label">Password</label>
          <input type="password" class="form-control" id="password" name="password"
                 v-model="user.password">
        </div>
        <div class="mb-3">
          <label for="confPassword" class="form-label">Confirm Password</label>
          <input type="password" class="form-control" id="confPassword" name="confPassword"
                 v-model="user.confirmPassword">
        </div>
        <div class="mb-3">
          <label for="firstname" class="form-label">First name</label>
          <input type="text" class="form-control" id="firstname" name="firstname"
                 v-model="user.firsName">
        </div>
        <div class="mb-3">
          <label for="lastName" class="form-label">Last name</label>
          <input type="text" class="form-control" id="lastName" name="lastName"
                 v-model="user.lastName">
        </div>
        <div class="mb-3">
          <label for="age" class="form-label">Age</label>
          <input type="text" class="form-control" id="age" name="age"
                 v-model="user.age">
        </div>
        <div class="mb-3">
          <label for="gender" class="form-label">Gender</label>
          <input type="text" class="form-control" id="gender" name="gender"
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
export default {
  name: 'registrationPage',
  data(){
    return{
      user:{
        username:null,
        password:null,
        confirmPassword:null,
        firsName: null,
        lastName: null,
        age:null,
        gender:null
      }
    }
  }
}
</script>
<style>

</style>