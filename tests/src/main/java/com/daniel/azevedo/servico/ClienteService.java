package com.daniel.azevedo.servico;

public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public String gerarMensagemDeBoasVindas(String email) {
        return clienteRepository.buscarNomePorEmail(email)
                .map(nome -> "Bem-vindo, " + nome + "!")
                .orElse("Usuário não encontrado.");
    }
}