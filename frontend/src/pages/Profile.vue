<template>
  <div class="container-xxl">
    <section style="min-height: 1000px">
      <div class="mt-lg-5" v-if="userIdIsExists">
        <div class="row">
          <div class="col-sm-3">
            <img src="https://media.istockphoto.com/id/1300845620/vector/user-icon-flat-isolated-on-white-background-user-symbol-vector-illustration.jpg?s=612x612&w=0&k=20&c=yBeyba0hUkh14_jgv1OKqIH0CCSWU_4ckRkAoy2p73o="
                 class="rounded-circle img-fluid"
                 alt="Avatar">
          </div>
          <div class="col-sm-9 mt-5">
            <h2>Username: {{user.username}}</h2>
            <h4>First Name: {{user.firstName}}</h4>
            <h4>Last Name: {{user.lastName}}</h4>
            <h4>Role: {{user.role}}</h4>
            <h4>Age: {{user.age}}</h4>
            <h4>Gender: {{user.gender}}</h4>
          </div>
        </div>
        <div class="ms-sm-2 ms-lg-5 mt-5">
          <button class="btn btn-danger" type="button" @click="logout">
            <div class="row">
              <div class="col-3">
                <svg class="bi" width="30" height="30" fill="currentColor">
                  <use xlink:href="../assets/bootstrap-icons.svg#person"/>
                </svg>
              </div>
              <div class="col">
                <h4>Logout</h4>
              </div>
            </div>
          </button>
        </div>
      </div>
      <section v-else>
        <h1 class="text-center mb-5">Loading ...</h1>
        <div class="d-flex justify-content-center">
          <div class="spinner-border" style="width: 6rem; height: 6rem;" role="status">
          </div>
        </div>
      </section>
    </section>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: 'ProfilePage',
  data(){
    return{
      user:{}
    }
  },
  computed:{
    userIdIsExists(){
      let id = this.$store.getters['authModule/getUserId'];
      if(id){
        this.loadUser(id);
        return true;
      }
      return false;
    }
  },
  methods:{
    async loadUser(userid){
      try {
        await axios.get('api/users/' + userid)
            .then(response =>{
              this.user = response.data
            })
      }catch (error){
        console.error(error)
      }
    },
    logout() {
      this.$store.dispatch('authModule/onLogout')
          .then(() => {
            location.reload();
          });
    },
  }
}
</script>
<style>
</style>
