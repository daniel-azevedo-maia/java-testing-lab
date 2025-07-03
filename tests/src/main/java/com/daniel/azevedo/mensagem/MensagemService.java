package com.daniel.azevedo.mensagem;

public class MensagemService {

    private Notificador notificador;

    public MensagemService(Notificador notificador) {
        this.notificador = notificador;
    }

    public void processarMensagem(String nome, String email) {
        String mensagem = "Olá " + nome + ", sua conta foi ativada!";
        notificador.enviarEmail(email, mensagem);
    }

}