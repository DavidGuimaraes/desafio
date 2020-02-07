package com.az.desafio.services;

import com.az.desafio.models.Licitacao;
import com.az.desafio.models.enums.TipoClassificacao;
import com.az.desafio.repositories.LicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// TODO - implementar uma classe ExceptionHandler

@Service
public class LicitacaoService {

    @Autowired
    private LicitacaoRepository dao;

    public Page<Licitacao> findAll(Pageable pageable){
        return this.dao.findAll(pageable);
    }

    public Licitacao findById(BigInteger id) throws Exception{
        Optional<Licitacao> licitacaoSalva = this.dao.findById(id);
        if(licitacaoSalva.isPresent()){
            return licitacaoSalva.get();
        }else {
            throw new Exception("Não foi encontrada uma licitação com o id informado");
        }
    }

    public List<TipoClassificacao> findTiposClassificacao(){
        return this.dao.findTiposClassificacao();
    }

    public Licitacao save(Licitacao licitacao){
        licitacao.setDataCadastro(new Date());
        licitacao.setDataUltimaEdicao(null);
        this.dao.save(licitacao);
        return licitacao;
    }

    public Licitacao update(Licitacao licitacao) throws Exception{
        Optional<Licitacao> licitacaoSalva = this.dao.findById(licitacao.getLicitacaoId());
        if(licitacaoSalva.isPresent()){
            licitacaoSalva.get().setDescricao(licitacao.getDescricao());
            licitacaoSalva.get().setTipoClassificacao(licitacao.getTipoClassificacao());
            licitacaoSalva.get().setDataUltimaEdicao(new Date());
            this.dao.save(licitacaoSalva.get());
            return licitacaoSalva.get();
        }else{
            throw new Exception("Não foi encontrada uma licitação com o id informado");
        }
    }

    public void delete(BigInteger id) throws Exception{
        Optional<Licitacao> licitacaoSalva = this.dao.findById(id);
        if(licitacaoSalva.isPresent()){
            this.dao.delete(licitacaoSalva.get());
        }else{
            throw new Exception("Não foi encontrada uma licitação com o id informado");
        }
    }
}
