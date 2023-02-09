

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculadoraTest {

    // Red - Escrever um teste que falha

    // Green -
    // Escreve o código que faz o teste passar (mínimo necessário)

    // Refactor - Melhorar nosso código



    @Test
    public void deveSomarCorretamente() {
        // Given
        Calculadora calculadora = new Calculadora();

        // When
        int a = 10;
        int b = 5;
        int resultado = calculadora.somar(a, b);

        //Then
        Assertions.assertEquals(15, resultado);
    }

    @Test
    public void deveSubtrairCorretamente() throws Exception {
        // Given
        Calculadora calculadora = new Calculadora();

        // When
        int a = 10;
        int b = 5;
        int resultado = calculadora.subtrair(a, b);

        // Then
        Assertions.assertEquals(5, resultado);
    }
}