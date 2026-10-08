package level_3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    @Test
    void calculatorStartsWithTotalZero() {
        Calculator calculator = new Calculator();
        assertThat(calculator.getTotal()).isEqualTo(0);
    }

    @Test
    void calculatorAddition() {
        Calculator calculator = new Calculator();
        calculator.add(5);
        assertThat(calculator.getTotal()).isEqualTo(5);
        calculator.add(5);
        assertThat(calculator.getTotal()).isEqualTo(10);
    }

    @Test
    void calculatorSubtraction() {
        Calculator calculator = new Calculator();
        calculator.subtract(5);
        assertThat(calculator.getTotal()).isEqualTo(-5);
        calculator.subtract(5);
        assertThat(calculator.getTotal()).isEqualTo(-10);
        // TODO: handle negative args cases in all
//        calculator.subtract(-5);
//        assertThat(calculator.getTotal()).isEqualTo(-15);
    }

    @Test
    void calculatorMultiplication() {
        Calculator calculator = new Calculator();
        calculator.multiply(5);
        assertThat(calculator.getTotal()).isEqualTo(0);
        calculator.add(10);
        calculator.multiply(5);
        assertThat(calculator.getTotal()).isEqualTo(50);
    }

    @Test
    void calculatorDivision() {
        Calculator calculator = new Calculator();
        calculator.add(10);
        calculator.divide(2);
        assertThat(calculator.getTotal()).isEqualTo(5);
    }

    @Test
    void calculatorDivisionByZero() {
        Calculator calculator = new Calculator();
        calculator.add(10);
        assertThrows(ArithmeticException.class, () -> calculator.divide(0));
    }

    @Test
    void calculatorReset() {
        Calculator calculator = new Calculator();
        calculator.add(10);
        calculator.multiply(5);
        calculator.divide(2);
        calculator.reset();
        assertThat(calculator.getTotal()).isEqualTo(0);
    }

}