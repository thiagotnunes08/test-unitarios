package com.example.test.cupom;

import java.math.BigDecimal;

public class Compra {

    private Usuario dono;
    private Produto produto;
    private BigDecimal valor;

    public Compra(Usuario dono, Produto produto, BigDecimal valor) {
        this.dono = dono;
        this.produto = produto;
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
