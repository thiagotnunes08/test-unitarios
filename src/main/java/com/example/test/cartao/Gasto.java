package com.example.test.cartao;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Gasto {

    private UUID id;

    private BigDecimal valor;

    private final LocalDateTime criadoEm = LocalDateTime.now();

    public Gasto(BigDecimal valor) {
        this.valor = valor;
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }
}
