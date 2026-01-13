import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    public Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Add test")
    public void addTest() {
        double result = calculator.add(2, 2);
        assertEquals(4, result);
    }

    @Test
    @DisplayName("Subtract test")
    public void subtractTest() {
        double result = calculator.subtract(2, 1);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Multiply test")
    public void multiplyTest() {
        double result = calculator.multiply(5, 3);
        assertEquals(15, result);
    }

    @Test
    @DisplayName("Divide test")
    public void divideTest() {
        double result = calculator.divide(15, 3);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Divide test")
    public void divideByZeroTest() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(2, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("isEven test with true result")
    public void isEvenTest() {
        boolean isEven = calculator.isEven(2);
        assertTrue(isEven);
    }

    @Test
    @DisplayName("isEven test with false result")
    public void isNotEvenTest() {
        boolean isEven = calculator.isEven(3);

        assertFalse(isEven);
    }

    @Test
    @DisplayName("get absolute value with negative number test")
    public void negativeAbsoluteValueTest() {
        int value = calculator.absoluteValue(-2);
        assertEquals(2, value);
    }

    @Test
    @DisplayName("get absolute value with positive number test")
    public void positiveAbsoluteValueTest() {
        int value = calculator.absoluteValue(2);
        assertEquals(2, value);
    }


    @Test
    @DisplayName("happy path average test")
    public void averageTestWithFullList() {
        double average = calculator.average(new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)));
        assertEquals(2, average);
    }

    @Test
    @DisplayName("empty list average test")
    public void averageTestWithEmptyList() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(new ArrayList<Double>());
        });
        assertEquals("List cannot be empty or null", exception.getMessage());
    }

    @Test
    @DisplayName("happy path maximum test")
    public void maximumTestWithFullList() {
        double maximum = calculator.maximum(new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)));
        assertEquals(3, maximum);
    }

    @Test
    @DisplayName("empty list maximum Test")
    public void maximumTestWithEmptyList() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.maximum(new ArrayList<Double>());
        });
        assertEquals("List cannot be empty or null", exception.getMessage());
    }

    @Test
    @DisplayName("happy path minimum test")
    public void minimumTestWithFullList() {
        double minimum = calculator.minimum(new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0)));
        assertEquals(1, minimum);
    }

    @Test
    @DisplayName("empty list minimum Test")
    public void minimumTestWithEmptyList() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.minimum(new ArrayList<Double>());
        });
        assertEquals("List cannot be empty or null", exception.getMessage());
    }

}
