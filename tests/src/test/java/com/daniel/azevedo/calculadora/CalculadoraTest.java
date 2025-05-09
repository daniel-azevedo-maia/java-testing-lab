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
        System.out.println("Iniciando a bateria de testes");
    }

    @AfterAll
    static void finalizar() {
        System.out.println("Finalizando a bateria de testes");
    }

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Nested
    @DisplayName("Testes de operações aritméticas")
    class OperacoesAritmeticasTest {
        @Test
        @DisplayName("Deve somar corretamente dois inteiros")
        void deveSomarDoisNumerosCorretamente() {
            assertEquals(5, calculadora.somar(2, 3));
        }

        @Test
        void deveSubtrairDoisNumerosCorretamente() {
            assertEquals(-4, calculadora.subtrair(4, 8));
        }

        @Test
        void deveMultiplicarDoisNumerosCorretamente() {
            assertEquals(45, calculadora.multiplicar(5, 9));
        }

        @Test
        void deveDividirDoisNumerosCorretamente() {
            assertEquals(3, calculadora.dividir(9, 3));
        }

        @Test
        void deveLancarExcecaoQuandoDividirPorZero() {
            assertThrows(ArithmeticException.class, () -> calculadora.dividir(5, 0));
        }

        @Test
        @DisplayName("Deve validar todas as operações básicas")
        void deveTestarVariosMetodosDeUmaVez() {
            assertAll(
                    () -> assertEquals(5, calculadora.somar(2, 3)),
                    () -> assertEquals(-4, calculadora.subtrair(4, 8)),
                    () -> assertEquals(45, calculadora.multiplicar(5, 9)),
                    () -> assertEquals(3, calculadora.dividir(9, 3))
            );
        }

        @Test
        void deveRetornarVerdadeiroParaNumerosPares() {
            assertTrue(calculadora.ehPar(10));
        }

        @Test
        void deveRetornarFalsoParaNumerosImpares() {
            assertFalse(calculadora.ehPar(7));
        }
    }

    @Test
    void deveRetornarDescricaoNaoNula() {
        assertNotNull(calculadora.gerarDescricao());
    }

    @Disabled("Ainda não implementado")
    @Test
    void testeDeFuncionalidade() {
        // Teste placeholder para futuras funcionalidades
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @DisplayName("Deve retornar true para todos os números pares")
    void deveRetornarVerdadeiroParaTodosOsNumerosPares(int numero) {
        assertTrue(calculadora.ehPar(numero));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "3, 4, 7",
            "10, 5, 15"
    })
    @DisplayName("Deve somar corretamente vários pares de números")
    void deveSomarCorretamenteVariosCasos(int a, int b, int esperado) {
        assertEquals(esperado, calculadora.somar(a, b));
    }
}