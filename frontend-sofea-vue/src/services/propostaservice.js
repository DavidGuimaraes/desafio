import { http } from './config'

export default {
    listar:() => {
        return http.get('propostas')
    },

    buscarPeloId:(id) => {
        return http.get('propostas/'+id);
    },

    salvar:(propostaDto) => {
        return http.post('propostas',propostaDto);
    },

    deletar:(id) => {
        return http.delete('propostas/'+id);
    },

    editar:(propostaBuscada) => {
        return http.put('propostas', propostaBuscada);
    }
}