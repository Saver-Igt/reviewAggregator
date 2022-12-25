<template>
  <div>
    <div id="carouselExampleDark"
         class="carousel carousel-dark slide shadow-sm"
         data-bs-ride="carousel"
         ref="myCarousel">
      <ol class="carousel-indicators mt-5 mb-5">
        <li
            data-bs-target="#carouselExampleDark"
            data-bs-slide-to="0"
            class="active">
        </li>
        <li
            data-bs-target="#carouselExampleDark"
            data-bs-slide-to="1">
        </li>
        <li
            data-bs-target="#carouselExampleDark"
            data-bs-slide-to="2">
        </li>
      </ol>

      <div class="carousel-inner">
        <div class="carousel-item active" data-bs-interval="10000">
          <div class="container-xxl">
            <div class="row align-items-center">
              <div class="col-7">
                <h1>Welcome to Review Aggregator!</h1>
                <h2 class="mt-4">Hello user! This is the place where you can share your opinion about the games and read the opinions of others.</h2>
              </div>
              <div class="col-5">
                <img class="w-100 h-200" src="../assets/logo.png" alt="">
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <div class="container-xxl">
            <div class="row align-items-center">
              <div class="col-7">
                <h1>Games</h1>
                <h2 class="mt-4">There are more than 10 games on our site and this list is constantly updated.</h2>
              </div>
              <div class="col-5">
                <img class="w-100 h-200 img-fluid" src="../assets/img2.jpg" alt="">
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container-xxl">
            <div class="row align-items-center">
              <div class="col-7">
                <h1>Welcome to Review Aggregator!</h1>
                <h2 class="mt-4">Hello user! This is the place where you can share your opinion about the games and read the opinions of others.</h2>
              </div>
              <div class="col-5">
                <img class="w-100 img-fluid" src="../assets/logo.png" alt="">
              </div>
            </div>
          </div>
        </div>
      </div>

      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>

    </div>
  </div>
</template>

<script>
export default{
  name: 'vCarusel',
}
</script>

<style>
.carousel-indicators {
  bottom: -2.4375rem;
}
.carousel-control-prev {
  margin-left: -25px;
}
.carousel-control-next {
  margin-right: -25px;
}
</style>