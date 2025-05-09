package com.daniel.azevedo.servico;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
