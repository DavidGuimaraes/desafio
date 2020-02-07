package com.az.desafio.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoClassificacao {
    @JsonProperty("Menor Preço")
    MENOR_PRECO("Menor Preço"),
    @JsonProperty("Nota Preço")
    NOTA_PRECO("Nota Preço");

    TipoClassificacao(String s) {
        this.tipo = s;
    }

    private String tipo;

    public String getTipo() {
        return tipo;
    }
}
