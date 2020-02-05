package com.az.desafio.repositories;

import com.az.desafio.models.Proposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface PropostaRepository extends JpaRepository<Proposta, BigInteger> {
}
