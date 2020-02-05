package com.az.desafio.models.dto;

import com.az.desafio.models.enums.TipoClassificacao;

import java.math.BigInteger;
import java.util.Date;

public class LicitacaoDto {

    private BigInteger id;
    private String descricao;
    private TipoClassificacao tipoClassificacao;
    private Date dataCadastro;
    private Date dataUltimaEdicao;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoClassificacao getTipoClassificacao() {
        return tipoClassificacao;
    }

    public void setTipoClassificacao(TipoClassificacao tipoClassificacao) {
        this.tipoClassificacao = tipoClassificacao;
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
}
