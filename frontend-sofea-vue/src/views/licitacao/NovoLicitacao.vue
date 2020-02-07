<template>
    <div>
        <Navbar />
        <br />
        <div class="container">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <b>NOVA LICITAÇÃO</b>
            </div>
            <!-- @submit.prevent="save" -->
            <form>
                <div class="mb-3">
                    <label for="descricao">Descrição</label>
                    <input type="email" class="form-control" placeholder="descrição" v-model="licitacaoDto.descricao">
                </div>
                <div class="row">
                    <div class="col-md-5 mb-3">
                        <label for="classificacao">Tipo de Classificação</label>
                        <select class="custom-select d-block w-100" id="country" v-model="licitacaoDto.tipoClassificacao">
                            <option :value="tipo" v-for="(tipo, index) in tiposClassificacao" v-bind:key="index">
                                {{ tipo }}
                            </option>
                        </select>
                        <!-- <select class="custom-select d-block w-100" id="country" v-model="licitacaoDto.tipoClassificacao">
                            <option value="Menor Preço">Menor Preço</option>
                            <option value="Nota Preço">Nota Preço</option>
                        </select> -->
                    </div>
                </div>
                <button type="button" class="btn btn-primary" v-on:click="save">Salvar</button>
                <router-link to="/licitacoes/" class="btn btn-danger">Cancelar</router-link>
            </form>
        </div>
        <p>{{ licitacaoDto }}</p>
    </div>
</template>

<script>
import Navbar from '@/components/Navbar'
import LicitacaoService from '@/services/licitacaoservice'

export default {
  name: 'app',
  components: {
    Navbar
  },
  data() {
      return {
          tiposClassificacao: [],
          licitacaoDto: {
              descricao: "",
              tipoClassificacao: ""
          }
      }
  },
  mounted() {
      LicitacaoService.listarTiposClassificacao().then(response => {
      this.tiposClassificacao = response.data
    })
  },
  methods: {
      save(){
          LicitacaoService.salvar(this.licitacaoDto).then(response => {
              alert('Salvo com sucesso! :)');
              response
              this.licitacaoDto = {descricao: "",tipoClassificacao: ""}
          })
      }
  }
}
</script>

<style></style>
