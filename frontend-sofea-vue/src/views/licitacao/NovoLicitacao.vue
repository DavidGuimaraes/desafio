<template>
    <div>
        <Navbar />
        <br />
        <div class="container">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <b>NOVA LICITAÇÃO</b>
            </div>
            <div class="mb-3">
                <label for="descricao">Descrição</label>
                <input type="email" class="form-control" placeholder="descrição">
            </div>
            <div class="row">
                <div class="col-md-5 mb-3">
                    <label for="classificacao">Tipo de Classificação</label>
                    <select class="custom-select d-block w-100" id="country" required>
                        <option value="">Escolha...</option>
                        <option>Teste</option>
                    </select>
                </div>
            </div>
            <button type="button" class="btn btn-primary">Salvar</button>
            <router-link to="/licitacoes/" class="btn btn-danger">Cancelar</router-link>
        </div>
    </div>
</template>

<script>
import Navbar from '@/components/Navbar'

export default {
  name: 'app',
  components: {
    Navbar
  }
}
</script>

<style></style>
