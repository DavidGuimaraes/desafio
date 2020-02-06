package com.az.desafio.models;

import com.az.desafio.models.enums.TipoClassificacao;
import com.az.desafio.utils.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name="licitacao")
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
public class Licitacao {

    @Id
    @GeneratedValue
    @Column(name="licitacao_id")
    private BigInteger licitacaoId;

    @Column(name="descricao")
    @NotNull
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_classificacao")
    @NotNull
    @Type( type = "pgsql_enum" )
    private TipoClassificacao tipoClassificacao;

    @Column(name="data_cadastro")
    @NotNull
    private Date dataCadastro;

    @Column(name="data_ultima_edicao")
    private Date dataUltimaEdicao;

    public BigInteger getLicitacaoId() {
        return licitacaoId;
    }

    public void setLicitacaoId(BigInteger licitacaoId) {
        this.licitacaoId = licitacaoId;
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
