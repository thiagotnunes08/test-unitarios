package com.example.test.nprimos;

public class NumeroPrimo {
    public boolean primo(int numero) {

        return primo(numero, 1, 0);

    }



    boolean primo(int numeroInicial, int numeroVariavel, int qtdDividido) {

        if (numeroInicial == 0 || numeroInicial == -1 || numeroInicial == 1) {

            return false;

        }



        if (numeroInicial % numeroVariavel == 0 && numeroInicial != numeroVariavel) {

            return primo(numeroInicial, numeroVariavel + 1, qtdDividido + 1);

        }



        if (numeroInicial % numeroVariavel != 0 && numeroVariavel <= numeroInicial) {

            return primo(numeroInicial, numeroVariavel + 1, qtdDividido);

        }



        return numeroInicial % numeroVariavel == 0 && qtdDividido + 1 == 2 && numeroInicial == numeroVariavel;

    }



}
