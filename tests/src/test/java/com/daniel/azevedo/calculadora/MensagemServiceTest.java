package com.daniel.azevedo.calculadora;

import com.daniel.azevedo.servico.MensagemService;
import com.daniel.azevedo.servico.Notificador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
}
