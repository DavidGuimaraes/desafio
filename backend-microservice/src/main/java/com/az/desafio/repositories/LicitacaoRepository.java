package com.az.desafio.repositories;

import com.az.desafio.models.Licitacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface LicitacaoRepository extends JpaRepository<Licitacao, BigInteger> {
}
