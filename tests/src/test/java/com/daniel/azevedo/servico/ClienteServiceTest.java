package com.daniel.azevedo.servico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteService clienteService;

    @Test
    void deveGerarMensagemDeBoasVindas() {
        // Configura o mock para retornar um nome ao buscar por email
        when(clienteRepository.buscarNomePorEmail("daniel@email.com"))
                .thenReturn(Optional.of("Daniel"));

        String mensagem = clienteService.gerarMensagemDeBoasVindas("daniel@email.com");

        assertEquals("Bem-vindo, Daniel!", mensagem);
    }

    @Test
    void deveRetornarMensagemDeErroSeEmailNaoForEncontrado() {
        when(clienteRepository.buscarNomePorEmail("naoexiste@email.com"))
                .thenReturn(Optional.empty());

        String mensagem = clienteService.gerarMensagemDeBoasVindas("naoexiste@email.com");

        assertEquals("Usuário não encontrado.", mensagem);

    }

    @Test
    void deveLancarExcecaoQuandoRepositorioFalha() {
        when(clienteRepository.buscarNomePorEmail("falha@email.com"))
                .thenThrow(new RuntimeException("Erro de conexão"));

        assertThrows(RuntimeException.class,
                () -> clienteService.gerarMensagemDeBoasVindas("falha@email.com"));

    }


}
