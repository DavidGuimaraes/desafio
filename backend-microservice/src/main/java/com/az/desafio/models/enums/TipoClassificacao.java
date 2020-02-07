package com.az.desafio.models.enums;

public enum TipoClassificacao {
    MENOR_PRECO("Menor Preço"),
    NOTA_PRECO("Nota Preço");

    TipoClassificacao(String s) {
        this.tipo = s;
    }

    private String tipo;

    public String getTipo() {
        return tipo;
    }
}
