import { http } from './config'

export default {
    listar:() => {
        return http.get('licitacoes')
    },
    listarTiposClassificacao:() => {
        return http.get('licitacoes/classificacoes')
    }
}