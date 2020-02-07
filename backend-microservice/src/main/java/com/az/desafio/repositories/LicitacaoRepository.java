package com.az.desafio.repositories;

import com.az.desafio.models.Licitacao;
import com.az.desafio.models.enums.TipoClassificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface LicitacaoRepository extends JpaRepository<Licitacao, BigInteger> {

    @Query(value = "SELECT DISTINCT lic.tipoClassificacao FROM Licitacao lic")
    List<TipoClassificacao> findTiposClassificacao();
}
