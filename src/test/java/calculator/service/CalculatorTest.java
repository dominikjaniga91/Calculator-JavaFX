package calculator.service;

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

    @Test
    void shouldReturnListWithMathSymbols(){
        int expected = 3;
        int actual = calculator.getMathSymbols("5+4-2+4").size();
        Assertions.assertEquals(expected, actual);
    }
}
