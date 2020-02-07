import { http } from './config'

export default {
    listar:() => {
        return http.get('propostas')
    },

    salvar:(propostaDto) => {
        return http.post('propostas',propostaDto);
    },

    deletar:(id) => {
        return http.delete('propostas/'+id);
    }
}