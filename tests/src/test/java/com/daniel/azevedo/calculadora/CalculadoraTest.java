package com.daniel.azevedo.calculadora;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Testes da classe Calculadora")
@Tag("UnitTest")
@Tag("FastTest")
public class CalculadoraTest {

    Calculadora calculadora;

    @BeforeAll
    static void iniciar() {
        // Setup geral antes de todos os testes
        System.out.println("Iniciando a bateria de testes");
    }

    @AfterAll
    static void finalizar() {
        // Cleanup geral após todos os testes
        System.out.println("Finalizando a bateria de testes");
    }

    @BeforeEach
    void setUp() {
        // Arrange comum a todos os testes
        calculadora = new Calculadora();
    }

    @Nested
    @DisplayName("Testes de operações aritméticas")
    class OperacoesAritmeticasTest {

        @Test
        @DisplayName("Deve somar corretamente dois inteiros")
        void deveSomarDoisNumerosCorretamente() {
            // Arrange: já feito em @BeforeEach

            // Act
            int resultado = calculadora.somar(2, 3);

            // Assert
            assertEquals(5, resultado);
        }

        @Test
        void deveSubtrairDoisNumerosCorretamente() {
            // Act
            int resultado = calculadora.subtrair(4, 8);

            // Assert
            assertEquals(-4, resultado);
        }

        @Test
        void deveMultiplicarDoisNumerosCorretamente() {
            // Act
            int resultado = calculadora.multiplicar(5, 9);

            // Assert
            assertEquals(45, resultado);
        }

        @Test
        void deveDividirDoisNumerosCorretamente() {
            // Act
            int resultado = calculadora.dividir(9, 3);

            // Assert
            assertEquals(3, resultado);
        }

        @Test
        void deveLancarExcecaoQuandoDividirPorZero() {
            // Act + Assert (ação e verificação ao mesmo tempo)
            assertThrows(ArithmeticException.class, () -> calculadora.dividir(5, 0));
        }

        @Test
        @DisplayName("Deve validar todas as operações básicas")
        void deveTestarVariosMetodosDeUmaVez() {
            // Assert (com múltiplos Acts embutidos)
            assertAll(
                    () -> assertEquals(5, calculadora.somar(2, 3)),
                    () -> assertEquals(-4, calculadora.subtrair(4, 8)),
                    () -> assertEquals(45, calculadora.multiplicar(5, 9)),
                    () -> assertEquals(3, calculadora.dividir(9, 3))
            );
        }

        @Test
        void deveRetornarVerdadeiroParaNumerosPares() {
            // Act
            boolean resultado = calculadora.ehPar(10);

            // Assert
            assertTrue(resultado);
        }

        @Test
        void deveRetornarFalsoParaNumerosImpares() {
            // Act
            boolean resultado = calculadora.ehPar(7);

            // Assert
            assertFalse(resultado);
        }
    }

    @Test
    void deveRetornarDescricaoNaoNula() {
        // Act
        String descricao = calculadora.gerarDescricao();

        // Assert
        assertNotNull(descricao);
    }

    @Disabled("Ainda não implementado")
    @Test
    void testeDeFuncionalidade() {
        // Arrange
        // Act
        // Assert
        // (ainda não implementado)
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Deve retornar true para todos os números pares")
    void deveRetornarVerdadeiroParaTodosOsNumerosPares(int numero) {
        // Act
        boolean resultado = calculadora.ehPar(numero);

        // Assert
        assertTrue(resultado);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "3, 4, 7",
            "10, 5, 15"
    })
    @DisplayName("Deve somar corretamente vários pares de números")
    void deveSomarCorretamenteVariosCasos(int a, int b, int esperado) {
        // Act
        int resultado = calculadora.somar(a, b);

        // Assert
        assertEquals(esperado, resultado);
    }
}
