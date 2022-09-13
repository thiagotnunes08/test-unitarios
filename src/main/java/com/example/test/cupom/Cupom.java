package com.example.test.cupom;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Cupom {

    private Usuario usuario;
    private Produto produto;
    private BigDecimal porcentagem;
    private LocalDateTime validoAte;

    public Cupom(Usuario usuario, Produto produto, BigDecimal porcentagem, LocalDateTime validoAte) {
        this.usuario = usuario;
        this.produto = produto;
        this.porcentagem = porcentagem;
        this.validoAte = validoAte;
    }

    public boolean ehValido(){

        return LocalDateTime.now().compareTo(validoAte) <= 0;
    }

    public boolean pertence(Usuario usuario){

        return this.usuario.equals(usuario);

    }

    public boolean pertence(Produto produto){

       return this.produto.equals(produto);
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public LocalDateTime getValidoAte() {
        return validoAte;
    }
}
