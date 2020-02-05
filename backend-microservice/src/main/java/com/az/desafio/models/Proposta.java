package com.az.desafio.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="proposta")
public class Proposta {

    @Id
    @GeneratedValue
    @Column(name="proposta_id")
    private BigInteger propostaId;

    @Column(name="nota")
    private BigDecimal nota;

    @Column(name="preco")
    @NotNull
    private BigDecimal preco;

    @Column(name="classificacao")
    private int classificacao;

    @Column(name="data_cadastro")
    @NotNull
    private Date dataCadastro;

    @Column(name="data_ultima_edicao")
    private Date dataUltimaEdicao;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="licitacao_id")
    @NotNull
    private Licitacao licitacao;

    public BigInteger getPropostaId() {
        return propostaId;
    }

    public void setPropostaId(BigInteger propostaId) {
        this.propostaId = propostaId;
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

    public Licitacao getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(Licitacao licitacao) {
        this.licitacao = licitacao;
    }
}
