package com.example.test.palindromo;

import java.text.Normalizer;

public class Palindromo {


    public boolean isPalindromo(String palavra) {


        if (palavra == null || palavra.isBlank()) {

            return false;

        }


        String palavraSemAcentosECaracteresEspeciais = Normalizer.normalize(palavra, Normalizer.Form.NFD)

                .replaceAll("[^\\p{ASCII}]", "")

                .toLowerCase()

                .replaceAll("[^a-z0-9]", "");


        return isPalindromoRecursive(palavraSemAcentosECaracteresEspeciais, 0, palavraSemAcentosECaracteresEspeciais.length() - 1);

    }


    private boolean isPalindromoRecursive(String palavra, int indexDaPontaEsquerdaDoArray, int indexDaPontaDireitaDoArray) {

        char[] letrasDaPalavra = palavra.toCharArray();

        char letraAtualDaPontaEsquerda = letrasDaPalavra[indexDaPontaEsquerdaDoArray];

        char letraAtualDaPontaDireita = letrasDaPalavra[indexDaPontaDireitaDoArray];


        if (indexDaPontaDireitaDoArray > 0 && letraAtualDaPontaEsquerda == letraAtualDaPontaDireita) {

            return isPalindromoRecursive(palavra, indexDaPontaEsquerdaDoArray + 1, indexDaPontaDireitaDoArray - 1);

        }


        return letraAtualDaPontaEsquerda == letraAtualDaPontaDireita;


    }


}
