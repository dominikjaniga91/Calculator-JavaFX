package service;

import calculator.service.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldReturnAppropriateResult_afterPlusNumbers(){
        int expected = 12;
        int actual = calculator.performCalculation("7+5");
        Assertions.assertEquals(expected, actual);
    }
}
