<template>
  <div class="container" id="app">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <!-- <a class="navbar-brand" href="#">Navbar</a> -->
        <img src="https://getbootstrap.com/docs/4.4/assets/brand/bootstrap-solid.svg" width="30" height="30" class="d-inline-block align-top" alt="">
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <router-link to="/" class="nav-item nav-link active">Home <span class="sr-only">(current)</span></router-link>
              <router-link to="/licitacoes" class="nav-item nav-link">Licitações</router-link>
              <router-link to="/propostas" class="nav-item nav-link">Propostas</router-link>
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
