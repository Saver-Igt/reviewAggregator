<template>
  <div class="container-fluid">
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
              <div class="col-sm-6">
                <h2>Welcome to Review Aggregator!</h2>
                <h3 class="mt-4">Hello user. This is the place where you can share your opinion about the games and read the opinions of others.</h3>
              </div>
              <div class="col-sm-6">
                <img class="w-100 h-200" src="../assets/logo.png" alt="">
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item" data-bs-interval="2000">
          <div class="container-xxl">
            <div class="row align-items-center">
              <div class="col-sm-6">
                <h2>Games</h2>
                <h3 class="mt-4">There are more than 10 games on our site and this list is constantly updated.</h3>
              </div>
              <div class="col-sm-6">
                <img class="w-100 h-200 img-fluid" src="../assets/img2.jpg" alt="">
              </div>
            </div>
          </div>
        </div>
        <div class="carousel-item">
          <div class="container-xxl">
            <div class="row align-items-center">
              <div class="col-sm-6">
                <h2>Interaction with Steam</h2>
                <h3 class="mt-4">
                  Valve's digital distribution service Steam is becoming more and more popular among gamers.
                  On our site you can see information about the game from Steam.
                  In the future, it is also planned to add the ability to connect your account to your Steam account in order to see a list of your games and reviews on them.</h3>
                <h5 class="mb-5 text-danger">* Information about some games may not be displayed because they are not in Steam or the publisher or developer has blocked access to the game in your region</h5>
              </div>
              <div class="col-sm-6">
                <img class="img-fluid" src="../assets/steam.png" alt="">
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
</style>