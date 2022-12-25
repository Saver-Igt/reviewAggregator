<template>
    <footer>
      <div class="container-xxl" id="footer">
        <div class="row">
          <div class="col-10 text-left">
            <a href="https://github.com/Saver-Igt" target="_blank" class="btn btn-outline-light">
              <svg class="bi" width="32" height="32" fill="currentColor">
                <use xlink:href="../assets/bootstrap-icons.svg#github"/>
              </svg>
            </a>
            <a href="https://t.me/X_lLuLl_X" target="_blank" class="btn btn-outline-light">
              <svg class="bi" width="32" height="32" fill="currentColor">
                <use xlink:href="../assets/bootstrap-icons.svg#telegram"/>
              </svg>
            </a>
            <a href="https://vk.com/radmirkk" target="_blank" class="btn btn-outline-light">
              <svg class="bi" width="32" height="32" fill="currentColor">
                <use xlink:href="../assets/bootstrap-icons.svg#chat"/>
              </svg>
            </a>
          </div>
          <div class="col-1">
            <a href="#app" class="btn btn-outline-light">
              <svg class="bi" width="32" height="32" fill="currentColor">
                <use xlink:href="../assets/bootstrap-icons.svg#arrow-up-square"/>
              </svg>
            </a>
          </div>
        </div>
      </div>
    </footer>
</template>

<script>
export default{
  name: 'vFooter',
}
</script>

<style>
footer{
  padding: 50px 0;
  padding-top: 50px;
  padding-bottom: 50px;

  background: var(--color1);
  background: -moz-linear-gradient(left,  var(--color1) 0%, var(--color2) 100%);
  background: -webkit-linear-gradient(left,  var(--color1) 0%,var(--color2) 100%);
  background: linear-gradient(to right,  var(--color1) 0%,var(--color2) 100%);
  filter: progid:DXImageTransform.Microsoft.gradient( startColorstr=var(--color1), endColorstr=var(--color2),GradientType=1 );
}
</style>