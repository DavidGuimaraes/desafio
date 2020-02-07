package com.az.desafio.services;

import com.az.desafio.models.Proposta;
import com.az.desafio.repositories.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

// TODO - implementar uma classe ExceptionHandler

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository dao;

    public Page<Proposta> findAll(Pageable pageable){
        return this.dao.findAll(pageable);
    }

    public Proposta findById(BigInteger id) throws Exception{
        Optional<Proposta> propostaSalva = this.dao.findById(id);
        if(propostaSalva.isPresent()){
            return propostaSalva.get();
        }else {
            throw new Exception("Não foi encontrada uma proposta com o id informado");
        }
    }

    public Proposta save(Proposta proposta){
        proposta.setDataCadastro(new Date());
        proposta.setDataUltimaEdicao(null);
        proposta.setClassificacao(0);
        this.dao.save(proposta);
        return proposta;
    }

    public Proposta update(Proposta proposta) throws Exception{
        Optional<Proposta> propostaSalva = this.dao.findById(proposta.getPropostaId());
        if(propostaSalva.isPresent()){
            propostaSalva.get().setNota(proposta.getNota());
            propostaSalva.get().setPreco(proposta.getPreco());
            propostaSalva.get().setLicitacao(proposta.getLicitacao());
            propostaSalva.get().setDataUltimaEdicao(new Date());
            this.dao.save(propostaSalva.get());
            return propostaSalva.get();
        }else{
            throw new Exception("Não foi encontrada uma proposta com o id informado");
        }
    }

    public void delete(BigInteger id) throws Exception{
        Optional<Proposta> propostaSalva = this.dao.findById(id);
        if(propostaSalva.isPresent()){
            this.dao.delete(propostaSalva.get());
        }else{
            throw new Exception("Não foi encontrada uma proposta com o id informado");
        }
    }
}
