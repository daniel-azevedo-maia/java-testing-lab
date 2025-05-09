package com.daniel.azevedo.clientesapi.service;

import com.daniel.azevedo.clientesapi.model.Cliente;
import com.daniel.azevedo.clientesapi.repository.ClienteRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteRepository clienteRepository;

    @InjectMocks
    ClienteService clienteService;

    @Nested
    @DisplayName("Cadastro de Cliente")
    class CadastroTests {

        @Test
        @DisplayName("Deve cadastrar cliente com sucesso")
        void deveCadastrarClienteComSucesso() {
            // Arrange
            Cliente cliente = new Cliente(null, "Daniel", "daniel@email.com");
            Cliente salvo = new Cliente(1L, "Daniel", "daniel@email.com");

            when(clienteRepository.salvar(cliente)).thenReturn(salvo);

            // Act
            Cliente resultado = clienteService.cadastrar(cliente);

            // Assert
            assertNotNull(resultado.getId());
            assertEquals("Daniel", resultado.getNome());
            verify(clienteRepository).salvar(cliente);
        }
    }

    @Nested
    @DisplayName("Busca de Cliente por ID")
    class BuscaPorIdTests {

        @Test
        @DisplayName("Deve buscar cliente por ID existente")
        void deveBuscarClientePorIdExistente() {
            // Arrange
            Cliente cliente = new Cliente(1L, "Daniel", "daniel@email.com");
            when(clienteRepository.buscarPorId(1L)).thenReturn(Optional.of(cliente));

            // Act
            Optional<Cliente> resultado = clienteService.buscarPorId(1L);

            // Assert
            assertNotNull(resultado);
            assertTrue(resultado.isPresent());
            assertEquals("Daniel", resultado.get().getNome());
            verify(clienteRepository).buscarPorId(1L);
        }
    }

    @Nested
    @DisplayName("Listagem de Clientes")
    class ListagemTests {

        @Test
        @DisplayName("Deve listar todos os clientes")
        void deveListarTodosOsClientes() {
            // Arrange
            List<Cliente> clientes = List.of(
                    new Cliente(1L, "Daniel", "daniel@email.com"),
                    new Cliente(2L, "Maria", "maria@email.com")
            );
            when(clienteRepository.listarTodos()).thenReturn(clientes);

            // Act
            List<Cliente> resultado = clienteService.listarTodos();

            // Assert
            assertEquals(2, resultado.size());
            assertEquals("Daniel", resultado.get(0).getNome());
            assertEquals("Maria", resultado.get(1).getNome());
            verify(clienteRepository).listarTodos();
        }
    }
}
