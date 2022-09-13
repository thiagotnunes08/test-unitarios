package com.example.test;

import com.example.test.palindromo.Palindromo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromoTest {
    private Palindromo palindromo = new Palindromo();

    @ParameterizedTest(name = "{index}=>entrada={0}")
    @MethodSource("primeiroIFMCDC")
    void struturalTestFuncaoPublica(String entrada) {

    assertFalse(palindromo.isPalindromo(entrada));

    }
    @ParameterizedTest(name = "{index}=>entrada={0},resultado={1}")
    @MethodSource("segundoIFMCDC")
    void struturalTestFuncaoPrivada(String entrada,boolean resultado){

        assertEquals(resultado,palindromo.isPalindromo(entrada));
    }

    @Test
    void nullNaoDeveSerPalidromo() {

        assertFalse(palindromo.isPalindromo(null));
    }

    private static Stream<Arguments> primeiroIFMCDC(){

        return Stream.of(
                Arguments.of(""),
                Arguments.of("araxa")
        );

    }

    private static Stream<Arguments> segundoIFMCDC(){
        return Stream.of(
                Arguments.of("ovo",true),
                Arguments.of("anA",true),
                Arguments.of("ána",true),
                Arguments.of("socorram-me subi no onibus em Marrocos",true),
                Arguments.of("raf",false),
                Arguments.of("o",true)
        );

    }
}