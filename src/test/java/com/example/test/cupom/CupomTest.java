package com.example.test.cupom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CupomTest {

    private Usuario usuario;
    private Cupom cupom;
    private Produto produto;
    private BigDecimal porcetagem;
    private final LocalDateTime HOJE = LocalDateTime.now();


    @BeforeEach
    void setUp() {
        this.usuario = new Usuario("Thiago Tomaz","thiago@zup.com");
        this.produto = new Produto("Livro Java 8",new BigDecimal("30"));
        this.porcetagem = new BigDecimal("0.1");

    }

    @Test
    @DisplayName("o cupom nao deve ser valido caso a data atual seja maior q a validade")
    void test1() {
        this.cupom = new Cupom(usuario,produto,porcetagem,HOJE.minusDays(1));

        assertFalse(cupom.ehValido());
    }

    @Test
    @DisplayName("o cupom  deve ser valido caso a data atual seja igual a data de validade")
    void test2() {
        this.cupom = new Cupom(usuario,produto,porcetagem,LocalDateTime.now());

        assertTrue(cupom.ehValido());

    }

    @Test
    @DisplayName("o cupom  deve ser valido caso a data de atual seja menor que a data de validade")
    void test3() {
        this.cupom = new Cupom(usuario,produto,porcetagem,HOJE.plusDays(1));

        assertTrue(cupom.ehValido());

    }
}