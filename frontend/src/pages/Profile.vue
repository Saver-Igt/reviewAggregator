<template>
  <div class="container-xxl">
    <section >
      <div class="row" v-if="userIdIsExists">
        <div class="col-3">
          <img src="https://media.istockphoto.com/id/1300845620/vector/user-icon-flat-isolated-on-white-background-user-symbol-vector-illustration.jpg?s=612x612&w=0&k=20&c=yBeyba0hUkh14_jgv1OKqIH0CCSWU_4ckRkAoy2p73o=" class="rounded-circle" style="width: 150px;"
               alt="Avatar" />
        </div>
        <div class="col-3">
          <p>Username: {{user.username}}</p>
          <p>First Name: {{user.firstName}}</p>
          <p>Last Name: {{user.lastName}}</p>
          <p>Role: {{user.role}}</p>
          <p>Age: {{user.age}}</p>
          <p>Gender: {{user.gender}}</p>
        </div>
        <div>
          <button class="btn btn-danger " type="button" @click="logout">
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
