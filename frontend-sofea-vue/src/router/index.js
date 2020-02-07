import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/views/Home'
import Licitacao from '@/views/Licitacao'
import NovoLicitacao from '@/views/licitacao/NovoLicitacao'
import EditarLicitacao from '@/views/licitacao/EditarLicitacao'
import Proposta from '@/views/Proposta'
import NovoProposta from '@/views/proposta/NovoProposta'

Vue.use(Router)

const routes = [
    {
        name: 'home',
        path: '/',
        component: Home,
    },
    {
        name: 'licitacao',
        path: '/licitacoes',
        component: Licitacao,
        children: [
            {
                //TODO - Revisar por que o parent component eh renderizado junto com o child nessa rota
                path: 'teste',
                name: 'novolicitacao',
                component: NovoLicitacao,
            },
        ]
    },
    {
        name: 'proposta',
        path: '/propostas',
        component: Proposta,
    },
    {
        //TODO - Workaround!!! Resolver o problema de renderizacao do parent e child para remover essa rota temporaria
        name: 'novolicitacaoteste',
        path: '/licitacoes/novo',
        component: NovoLicitacao,
    },
    {
        //TODO - Workaround!!! Resolver o problema de renderizacao do parent e child para remover essa rota temporaria
        name: 'editarlicitacaoteste',
        path: '/licitacoes/editar/:id',
        component: EditarLicitacao,
        props: true,
    },
    {
        //TODO - Workaround!!! Resolver o problema de renderizacao do parent e child para remover essa rota temporaria
        name: 'novopropostateste',
        path: '/propostas/novo',
        component: NovoProposta,
    }
]

const router = new Router({ routes })

export default router