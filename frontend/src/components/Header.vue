<template>
  <header>
    <nav class="navbar navbar-expand-lg nav-pills">
      <div class="container-xxl">
        <a class="navbar-brand text-white" href="/">Review Aggregator</a>
        <button class="navbar-toggler" data-bs-toggle="collapse" data-target="#collapseExample"
                href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapseExample">
          <ul class="nav nav-pills me-auto mb-2 mb-lg-0">
            <li class="nav-item m-2">
              <button class="nav-link" data-bs-toggle="tab"
                      @click="$router.push({name:'games'})">
                Games
              </button>
            </li>
            <li class="nav-item m-2">
              <button class="nav-link" data-bs-toggle="tab"
                      v-bind:disabled="!username"
                      @click="$router.push({name:'reviews'})">
                Your reviews
              </button>
            </li>
            <li class="nav-item m-2">
              <button class="nav-link" data-bs-toggle="tab"
                      @click="$router.push({name:'FAQ'})">
                FAQ
              </button>
            </li>
            <li class="nav-item">
              <a class="nav-link text-white m-2" href="#footer">Contacts</a>
            </li>
          </ul>
          <!--
          <form class="d-flex m-2" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-primary" type="submit">Find
              <i class="fas fa-search"></i>
            </button>
          </form>
          -->
          <!--For login -->
          <button type="button" class="btn btn-primary m-2" v-if="!username"
                  data-bs-toggle="modal" data-bs-target="#loginModal">
            <svg class="bi" width="24" height="24" fill="currentColor">
              <use xlink:href="../assets/bootstrap-icons.svg#person-circle"/>
            </svg>
          </button>
          <!-- For already login-->
          <div class="" v-if="username">
            <button class="btn btn-success" type="button" @click="openProfile">
              <div class="row">
                <div class="col fst-italic text-decoration-underline">{{username}}</div>
                <div class="col">
                  <div class="vr"></div>
                </div>
                <div class="col">
                  <svg class="bi" width="24" height="24" fill="currentColor">
                    <use xlink:href="../assets/bootstrap-icons.svg#person"/>
                  </svg>
                </div>
              </div>
            </button>
          </div>
        </div>
      </div>
    </nav>
  </header>
  <login-pop-up/>
</template>

<script>
import loginPopUp from "@/components/loginPopUp.vue";
export default{
  name:'v-header',
  components:{
    loginPopUp
  },
  computed:{
    username(){
      return this.$store.getters['authModule/getUsername'];
    },
    games(){
      return this.$store.getters['gamesModule/getGame'];
    }
  },
  methods:{
    openProfile(){
      this.$router.push({name: 'profile'});
    }
  }
}
</script>
<style>
  header{
    width: 100%;
    position: sticky;
    top: 0;
    z-index: 100;

    background: var(--color1);
    background: -moz-linear-gradient(left,  var(--color1) 0%, var(--color2) 100%);
    background: -webkit-linear-gradient(left,  var(--color1) 0%,var(--color2) 100%);
    background: linear-gradient(to right,  var(--color1) 0%,var(--color2) 100%);
    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr=var(--color1), endColorstr=var(--color2),GradientType=1 );
  }
</style>