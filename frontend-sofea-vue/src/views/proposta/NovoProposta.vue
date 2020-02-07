<template>
<!-- TODO - Implementar mensagens/notificacoes para o usuario aqui nessa tela -->
<!-- TODO - Tratar possiveis excecoes disparadas pela API -->
    <div>
        <Navbar />
        <br />
        <div class="container">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <b>NOVA PROPOSTA</b>
            </div>
            <form>
                <div class="mb-3">
                    <label for="nota">Nota</label>
                    <input type="email" class="form-control" placeholder="nota" v-model="propostaDto.nota">
                </div>
                <div class="mb-3">
                    <label for="preco">Preço</label>
                    <input type="email" class="form-control" placeholder="preço" v-model="propostaDto.preco">
                </div>
                <div class="mb-3">
                    <label for="licitacaoId">Id da Licitação</label>
                    <input type="email" class="form-control" placeholder="licitação" v-model="propostaDto.licitacaoId">
                </div>
                <button type="button" class="btn btn-primary" v-on:click="save">Salvar</button>
                <router-link to="/propostas/" class="btn btn-danger">Cancelar</router-link>
            </form>
        </div>
    </div>
</template>

<script>
import Navbar from '@/components/Navbar'
import PropostaService from '@/services/propostaservice'

export default {
  name: 'app',
  components: {
    Navbar
  },
  data() {
      return {
        propostaDto: {
            nota: "0",
            preco: "0.0",
            licitacaoId: ""

        }
      }
  },
  methods: {
      save() {
          PropostaService.salvar(this.propostaDto).then(response => {
              alert('Salvo com sucesso! :)');
              response
              this.propostaDto = {nota: "0",preco: "0.0", licitacaoId: ""}
          })
      }
  }
}
</script>

<style></style>
