<template>
<!-- TODO - Implementar mensagens/notificacoes para o usuario aqui nessa tela -->
<!-- TODO - Tratar possiveis excecoes disparadas pela API -->
    <div>
      <Navbar />
      <br />
      <div class="container">
        <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
          <b>LICITAÇŌES</b>
          <div class="form-inline">
            <router-link to="/licitacoes/novo" class="btn btn-outline-success my-2 my-sm-0">Novo</router-link>
          </div>
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
                <th scope="col">Ações</th>
              </tr>
            </thead>
            <tbody v-if="licitacoes.length > 0">
              <tr v-for="(licitacao, index) in licitacoes" v-bind:key="index">
                <th scope="row">{{ licitacao.id }}</th>
                <td>{{ licitacao.descricao }}</td>
                <td>{{ licitacao.tipoClassificacao }}</td>
                <td>{{ licitacao.dataCadastro }}</td>
                <td>{{ licitacao.dataUltimaEdicao }}</td>
                <td>
                  <div class="btn-group btn-group-sm" role="group" aria-label="Basic example">
                    <button type="button" class="btn btn-danger" @click="deletar(licitacao.id)">Deletar</button>
                    <router-link :to="{name: 'editarlicitacaoteste', params: {id: licitacao.id}}" class="btn btn-primary">Editar</router-link>
                  </div>
                </td>
              </tr>
            </tbody>
            <p v-else>Nenhum dado foi encontrado...</p>
          </table>
          <!-- <p>{{ licitacoes }}</p> -->
        </div>
        <keep-alive><router-view /></keep-alive>
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
        licitacoes: [],
    }
  },
  mounted() {
    this.listar()
  },
  methods: {
    listar() {
      LicitacaoService.listar().then(response => {
        this.licitacoes = response.data.content
      })
    },
    deletar(id) {
      LicitacaoService.deletar(id).then(response => {
        alert('Deletado com sucesso!');
        this.listar();
        response
      })
    }
  }
}
</script>

<style></style>