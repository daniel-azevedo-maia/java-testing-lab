package com.daniel.azevedo.mensagem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MensagemServiceTest {

    @Mock
    Notificador notificador;

    @InjectMocks
    MensagemService mensagemService;

    @Test
    void deveChamarMetodoEnviarEmail() {
        mensagemService.processarMensagem("Daniel", "daniel@teste.com");
        verify(notificador).enviarEmail("daniel@teste.com", "Olá Daniel, sua conta foi ativada!");
    }

    @Test
    void deveEnviarEmailDuasVezes() {
        mensagemService.processarMensagem("Daniel", "daniel@teste.com");
        mensagemService.processarMensagem("Daniel", "daniel@teste.com");


        verify(notificador, times(2))
                .enviarEmail("daniel@teste.com", "Olá Daniel, sua conta foi ativada!");

    }

}
