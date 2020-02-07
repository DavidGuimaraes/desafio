<template>
    <div>
        <Navbar />
        <br />
        <div class="container">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
            <b>PROPOSTAS</b>
            <div class="form-inline">
              <router-link to="/propostas/novo" class="btn btn-outline-success my-2 my-sm-0">Novo</router-link>
            </div>
          </div>
          <br />
          <br />
          <br />
          <table class="table">
              <thead>
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Nota</th>
                  <th scope="col">Preço</th>
                  <th scope="col">Classificação</th>
                  <th scope="col">Licitação</th>
                  <th scope="col">Data de Cadastro</th>
                  <th scope="col">Data Última Edição</th>
                  <th scope="col">Ações</th>
                </tr>
              </thead>
              <tbody v-if="propostas.length > 0">
                <tr v-for="(proposta, index) in propostas" v-bind:key="index">
                  <th scope="row">{{ proposta.id }}</th>
                  <td>{{ proposta.nota }}</td>
                  <td>{{ proposta.preco }}</td>
                  <td>{{ proposta.classificacao }}</td>
                  <td>{{ proposta.licitacaoId }}</td>
                  <td>{{ proposta.dataCadastro }}</td>
                  <td>{{ proposta.dataUltimaEdicao }}</td>
                  <td>
                    <button type="button" class="btn btn-danger" @click="deletar(proposta.id)">Deletar</button>
                  </td>
                </tr>
              </tbody>
              <p v-else>Nenhum dado foi encontrado...</p>
            </table>
            <!-- <p>{{ propostas }}</p> -->
        </div>
        <keep-alive><router-view /></keep-alive>
    </div>
</template>

<script>
import Navbar from '../components/Navbar'
import PropostaService from '../services/propostaservice'

export default {
  name: 'app',
  components: {
    Navbar
  },
  data() {
    return {
      propostasHardCoded: [
          {
            id: 1,
            nota: 8.0,
            preco: 250,
            classificacao: 0,
            licitacao: {
                id: 1,
                descricao: "Teste Hard Coded",
                tipoClassificacao: "NOTA_PRECO",
                dataCadastro: "2020-02-06",
                dataUltimaEdicao: ""
            },
            dataCadastro: "2020-02-06",
            dataUltimaEdicao: "-"
          }
      ],
      propostas: []
    }
  },
  mounted() {
    this.listar()
  },
  methods: {
    listar() {
      PropostaService.listar().then(response => {
        this.propostas = response.data.content
      })
    },
    deletar(id) {
      PropostaService.deletar(id).then(response => {
        alert('Deletado com sucesso!');
        this.listar();
        response
      })
    }
  }
}
</script>

<style></style>