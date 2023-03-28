<template>
  <div class="container-xxl">
    <div class="mt-5 mb-5">
      <h1>Registration</h1>
      <form>
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