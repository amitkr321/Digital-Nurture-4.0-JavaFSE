import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import test.Calculator;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setting up...");
    }

    @AfterEach
    void tearDown() {
        calculator = null;
        System.out.println("Tearing down...");
    }

    @Test
    void testAddition() {
        int a = 5;
        int b = 3;
        int result = calculator.add(a, b);

        assertEquals(8, result);
    }

    @Test
    void testSubtraction() {
        int a = 10;
        int b = 4;
        int result = calculator.subtract(a, b);

        assertEquals(6, result);
    }

    @Test
    void testMultiplication() {
        int a = 6;
        int b = 7;
        int result = calculator.multiply(a, b);

        assertEquals(42, result);
    }

    @Test
    void testDivision() {
        int a = 20;
        int b = 5;
        int result = calculator.divide(a, b);

        assertEquals(4, result);
    }

    @Test
    void testDivideByZeroThrowsException() {
        int a = 10;
        int b = 0;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(a, b));
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }
}