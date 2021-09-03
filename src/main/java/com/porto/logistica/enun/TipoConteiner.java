package com.porto.logistica.enun;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoConteiner {
    VINTE(20),
    QUARENTA(40);

    @JsonValue
    private final int valor;
    TipoConteiner(int valorTipo){
        this.valor = valorTipo;
    }

    @JsonCreator
    public static TipoConteiner fromNumber(int number) {
        for (TipoConteiner b : TipoConteiner.values()) {
            if (b.valor == number) {
                return b;
            }
        }
        return null;
    }
}
