package com.daniel.azevedo.calculadora;

public class Calculadora {

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int a, int b) {
        return a / b;
    }

    public boolean ehPar(int numero) {
        return numero % 2 == 0;
    }

    public String gerarDescricao() {
        return "Calculadora simples";
    }
}
