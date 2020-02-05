package com.az.desafio.models.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class PropostaDto {

    private BigInteger id;
    private BigDecimal nota;
    private BigDecimal preco;
    private int classificacao;
    private Date dataCadastro;
    private Date dataUltimaEdicao;
    private BigInteger licitacaoId;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaEdicao() {
        return dataUltimaEdicao;
    }

    public void setDataUltimaEdicao(Date dataUltimaEdicao) {
        this.dataUltimaEdicao = dataUltimaEdicao;
    }

    public BigInteger getLicitacaoId() {
        return licitacaoId;
    }

    public void setLicitacaoId(BigInteger licitacaoId) {
        this.licitacaoId = licitacaoId;
    }
}
