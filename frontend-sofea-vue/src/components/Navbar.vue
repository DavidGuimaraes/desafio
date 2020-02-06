<template>
  <div class="container" id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- <a class="navbar-brand" href="#">Navbar</a> -->
        <img src="https://getbootstrap.com/docs/4.4/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
            <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="#"><feather-activity></feather-activity>Licitações</a>
            <a class="nav-item nav-link" href="#">Propostas</a>
            <a class="nav-item nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
            </div>
        </div>
    </nav>

    <activity-icon></activity-icon>
  </div>
</template>

<script>
import { Activity } from 'vue-feather-icon'

  export default {
    components: {
      ActivityIcon: Activity
    }
  }
</script>

<style></style>
