<template>
    <div>
        <Navbar />
        <br />
        <div class="container">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <b>LICITAÇŌES</b>
          </div>
          <br />
          <br />
          <br />
            <table class="table">
              <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Descrição</th>
                  <th scope="col">Tipo de Classificação</th>
                  <th scope="col">Data de Cadastro</th>
                  <th scope="col">Data Última Edição</th>
                </tr>
              </thead>
              <tbody v-if="licitacoes.length > 0">
                <tr v-for="(licitacao, index) in licitacoes" v-bind:key="index">
                  <th scope="row">{{ licitacao.id }}</th>
                  <td>{{ licitacao.descricao }}</td>
                  <td>{{ licitacao.tipoClassificacao }}</td>
                  <td>{{ licitacao.dataCadastro }}</td>
                  <td>{{ licitacao.dataUltimaEdicao }}</td>
                </tr>
              </tbody>
              <p v-else>Nenhum dado foi encontrado...</p>
            </table>
            <!-- <p>{{ licitacoes }}</p> -->
        </div>
    </div>
</template>

<script>
import Navbar from '../components/Navbar'
import LicitacaoService from '../services/licitacaoservice'

export default {
  name: 'app',
  components: {
    Navbar
  },
  data() {
    return {
      strings:[
        'Mark', 
        'Otto', 
        'Billy', 
        '@mdo'],
      licitacoesHardCoded: [
          {
            id: 1,
            descricao: "Teste Hard Coded",
            tipoClassificacao: "NOTA_PRECO",
            dataCadastro: "2020-02-06",
            dataUltimaEdicao: "-"
          }
        ],
        licitacoes: []
    }
  },
  mounted() {
    LicitacaoService.listar().then(response => {
      this.licitacoes = response.data.content
    })
  }
}
</script>

<style></style>