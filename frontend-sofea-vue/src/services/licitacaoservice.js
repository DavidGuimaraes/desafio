import { http } from './config'

export default {
    listar:() => {
        return http.get('licitacoes')
    },

    listarTiposClassificacao:() => {
        return http.get('licitacoes/classificacoes')
    },

    salvar:(licitacaoDto) => {
        return http.post('licitacoes',licitacaoDto);
    },

    deletar:(id) => {
        return http.delete('licitacoes/'+id);
    },

    buscarPeloId:(id) => {
        return http.get('licitacoes/'+id);
    },

    editar:(licitacaoBuscada) => {
        return http.put('licitacoes', licitacaoBuscada);
    }
}