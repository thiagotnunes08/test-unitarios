package com.example.test.cartao;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Fatura {

    private Cartao cartao;

    private YearMonth mesAno;

    private List<Gasto> gastos = new ArrayList<>();

    public Fatura(Cartao cartao, YearMonth mesAno, List<Gasto> gastos) {
        this.cartao = cartao;
        this.mesAno = mesAno;
        this.gastos = gastos;
    }

    public void adiciona(Gasto gasto){

        this.gastos.add(gasto);
    }

    public BigDecimal getValor(){
        return gastos.stream()
                .map(Gasto::getValor)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

    public YearMonth getMesAno() {
        return mesAno;
    }
}
