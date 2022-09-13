package com.example.test.cartao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartaoTest {

    private Cartao cartao;
    private List<Fatura> faturas;
    private YearMonth MES_ATUAL = YearMonth.now();
    private YearMonth PROXIMO_MES = MES_ATUAL.plusMonths(1);

    private YearMonth DOIS_MESES_DE_HOJE = PROXIMO_MES.plusMonths(1);


    @Test
    @DisplayName("deve aprovar uma compra caso o tenha limite disponivel e codigo de seguranca e senha sejam validos")
    void test() {
        String codigoSeguranca = "234";
        String senha = "1234";

        this.cartao = new Cartao(
                "12321",
                "Jordi h",
                codigoSeguranca,
                senha,
                new BigDecimal("130"),
                LocalDateTime.now().plusYears(2)
        );

        faturas = criaFaturas(this.cartao);
        cartao.adicionar(faturas);

        assertTrue(cartao.isAprovado(new Gasto(BigDecimal.TEN), "234", "1234"));
    }

    @Test
    @DisplayName("nao deve aprovar caso a senha esteja incorreta")
    void test2() {
        String codigoSeguranca = "123";
        String senha = "1234";

        this.cartao = new Cartao(
                "1234-1234",
                "thiago",
                codigoSeguranca,"1233",
                new BigDecimal("130"),
                LocalDateTime.now().plusYears(2)
        );

        faturas = criaFaturas(this.cartao);
        cartao.adicionar(faturas);

        assertFalse(cartao.isAprovado(new Gasto(BigDecimal.TEN),codigoSeguranca,senha));

    }

    @Test
    @DisplayName("nao deve aprovar caso o codigo esteja errado")
    void test3() {
        String codigoSeguranca = "12345";
        String senha = "12345";

        this.cartao = new Cartao(
                "123456-123",
                "Thiago",
                codigoSeguranca,
                senha,
                new BigDecimal("130"),
                LocalDateTime.now().plusYears(3)
        );

        faturas = criaFaturas(this.cartao);
        cartao.adicionar(faturas);

        assertFalse(cartao.isAprovado(new Gasto(BigDecimal.TEN),"123415",senha));

    }

    @Test
    @DisplayName("nao deve aprovar caso o limite seja insuficiente")
    void test4() {
        String senha = "1234";
        String codSeguranca = "12345";

        this.cartao = new Cartao(
                "123450-33",
                "thiago",
                codSeguranca,
                senha,
                new BigDecimal("129"),
                LocalDateTime.now().plusYears(3)
        );

        faturas = criaFaturas(this.cartao);
        cartao.adicionar(faturas);

        assertFalse(cartao.isAprovado(new Gasto(BigDecimal.TEN),codSeguranca,senha));
    }

    private List<Fatura> criaFaturas(Cartao cartao) {

        return List.of(
                new Fatura(
                        cartao,
                        MES_ATUAL,
                        List.of(
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN)
                        )
                ),
                new Fatura(
                        cartao,
                        PROXIMO_MES,
                        List.of(
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN)
                        )
                ),

                new Fatura(
                        cartao,
                        DOIS_MESES_DE_HOJE,
                        List.of(
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN),
                                new Gasto(BigDecimal.TEN)
                        )
                )
        );
    }
}