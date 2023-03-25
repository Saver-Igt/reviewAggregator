<template>
  <div class="container-xxl mt-5">
    <section>
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
        <button type="submit" class="btn btn-primary" @click="sendUser">Submit</button>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
      </form>
    </section>
  </div>
</template>
<script>
import axios from "axios";
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
    sendUser() {
      axios.post('/api/auth/login',
          JSON.stringify(this.user), {
            headers:{'Content-Type': 'application/json; charset=utf-8'}
          })
          .then(response => {
            this.res = response;
            console.log('Log ' + response);
          })
          .catch(error => {
            alert(error);
          });
    }
  }
}
</script>
<style>

</style>