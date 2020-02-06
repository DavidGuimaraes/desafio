package com.az.desafio.repositories;

import com.az.desafio.models.Licitacao;
import com.az.desafio.models.enums.TipoClassificacao;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.Optional;

public interface LicitacaoRepository extends JpaRepository<Licitacao, BigInteger> {

    /*@Query(value = "SELECT l FROM Licitacao l WHERE Licitacao.tipoClassificacao = classificacao")
    Optional<Licitacao> findByClassificacao(TipoClassificacao classificacao);*/
}
