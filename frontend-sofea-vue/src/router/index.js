import Vue from 'vue'
import Router from 'vue-router'

import Home from '@/views/Home'
import Licitacao from '@/views/Licitacao'
import Proposta from '@/views/Proposta'

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
    },
    {
        name: 'proposta',
        path: '/propostas',
        component: Proposta,
    }
]

const router = new Router({ routes })

export default router