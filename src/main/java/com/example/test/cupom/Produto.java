package com.example.test.cupom;

import java.math.BigDecimal;

public class Produto {

    private String nome;
    private BigDecimal preco;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Compra compra(Cupom cupom, Usuario usuario){
    if (cupom.pertence(this) && cupom.pertence(usuario) && cupom.ehValido()){

        BigDecimal valorDesconto = preco.multiply(cupom.getPorcentagem());

        return new Compra(usuario,this,preco.subtract(valorDesconto));

    }

    return new Compra(usuario,this,preco);

    }


}
