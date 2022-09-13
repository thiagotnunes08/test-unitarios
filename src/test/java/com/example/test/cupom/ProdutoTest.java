package com.example.test.cupom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    private Usuario usuario1;
    private Usuario usuario2;
    private BigDecimal desconto;
    private Produto produto1;
    private Produto produto2;


    @BeforeEach
    void setUp() {
        this.usuario1 = new Usuario("Thiago","thiago@zup.com");
        this.usuario2 = new Usuario("Mith","mith@acai.com");
        this.desconto = new BigDecimal("0.1");
        this.produto1 = new Produto("Livro java 8",BigDecimal.TEN);
    }

    @Test
    @DisplayName("cumpom pertece ao produto, pertence ao usuario e eh valido")
    void test1() {
        Cupom cupom = new Cupom(usuario1,produto1,desconto, LocalDateTime.now().plusDays(1));

        Compra compra = produto1.compra(cupom,usuario1);

        assertTrue(cupom.ehValido());

        assertTrue(cupom.pertence(produto1));

        assertTrue(cupom.pertence(usuario1));

        assertEquals(BigDecimal.TEN.multiply(BigDecimal.ONE.subtract(desconto)),compra.getValor());

    }

    @Test
    @DisplayName("cumpom pertece ao produto, pertence ao usuario e eh invalido")
    void test2() {
        Cupom cupom = new Cupom(usuario1,produto1,desconto,LocalDateTime.now().minusDays(1));

        Compra compra = produto1.compra(cupom,usuario2);

        assertTrue(cupom.pertence(usuario1));

        assertTrue(cupom.pertence(produto1));

        assertFalse(cupom.ehValido());

        assertEquals(BigDecimal.TEN,compra.getValor());

    }

    @Test
    @DisplayName("cumpom pertece ao produto, nao pertence ao usuario e eh valido")
    void test3() {
        Cupom cupom = new Cupom(usuario2,produto1,desconto,LocalDateTime.now());

        Compra compra = produto1.compra(cupom,usuario1);

        assertTrue(cupom.pertence(produto1));

        assertFalse(cupom.pertence(usuario1));

        assertTrue(cupom.ehValido());

        assertEquals(BigDecimal.TEN,compra.getValor());

    }
}