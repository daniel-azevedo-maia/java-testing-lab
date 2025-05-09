package com.daniel.azevedo.clientesapi.controller;

import com.daniel.azevedo.clientesapi.model.Cliente;
import com.daniel.azevedo.clientesapi.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired
    MockMvc mock;

    @MockitoBean
    ClienteService clienteService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Deve cadastrar cliente com sucesso via POST /clientes")
    void deveCadastrarCliente() throws Exception {
        // --- ARRANGE ---
        Cliente cliente = new Cliente(null, "Daniel", "daniel@email.com");
        Cliente clienteSalvo = new Cliente(1L, "Daniel", "daniel@email.com");

        // Simula o comportamento do service quando chamado com o cliente correto
        when(clienteService.cadastrar(cliente)).thenReturn(clienteSalvo);

        // --- ACT & ASSERT ---
        mock.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cliente)))
                .andExpect(status().isOk()) // Verifica se o status HTTP é 200
                .andExpect(jsonPath("$.id").value(1L)) // Verifica se o campo "id" é 1
                .andExpect(jsonPath("$.nome").value("Daniel")) // Verifica se o campo "nome" é "Daniel"
                .andExpect(jsonPath("$.email").value("daniel@email.com")); // Verifica se o campo "email" está correto
    }
}
