<template>
    <div>
        <Navbar />
        <br />
        <div class="container">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <b>HOME</b>
          </div>
          <div class="jumbotron">
            <h1 class="display-4">Bem-Vindx!</h1>
            <p class="lead">Este é um sistema simples de classificação de propostas de licitações. Um sistema simples e ainda em evolução, mas perfeito para a AZ contratar o David! :)</p>
            <hr class="my-4">
            <p>Gostaria de conhecer um pouco mais o meu trabalho? Visite os links abaixo!</p>
            <!-- <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a> -->
            <p>Under Construction...</p>
          </div>
        </div>
        <router-view></router-view>
    </div>
</template>

<script>
import Navbar from '../components/Navbar'

export default {
  name: 'app',
  components: {
    Navbar
  }
}
</script>

<style></style>