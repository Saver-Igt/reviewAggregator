<template>
  <header>
    <nav class="navbar navbar-expand-lg nav-pills">
      <div class="container-xxl">
        <a class="navbar-brand text-white" href="/">Review Aggregator</a>
        <button
            class="navbar-toggler"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="nav nav-pills me-auto mb-2 mb-lg-0">
            <li class="nav-item m-2">
              <button class="nav-link" data-bs-toggle="tab"
                      @click="$router.push({name:'games'})">
                Games
              </button>
            </li>
            <li class="nav-item m-2">
              <button class="nav-link" data-bs-toggle="tab"
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
          <form class="d-flex m-2" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-primary" type="submit">Find</button>
          </form>
          <button type="button" class="btn btn-success m-2"
                  @click="$router.push({name:'login'})">
            <svg class="bi" width="24" height="24" fill="currentColor">
              <use xlink:href="../assets/bootstrap-icons.svg#person-circle"/>
            </svg>
          </button>
        </div>
      </div>
    </nav>
  </header>
</template>

<script>
export default{
  name:'v-header',
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