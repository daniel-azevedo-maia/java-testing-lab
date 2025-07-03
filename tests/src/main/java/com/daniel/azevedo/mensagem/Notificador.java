package com.daniel.azevedo.mensagem;

public class Notificador {
    public void enviarEmail(String destino, String mensagem) {
        System.out.printf("Enviando e-mail para %s: %s%n", destino, mensagem);
    }
}