package calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void shouldReturnListWithNumbers(){
        List<Double> expected = List.of(5d,4d,2d,4d);
        List<Double> actual = calculator.getNumbers("5+4-2+4");
        Assertions.assertEquals(expected, actual);
    }
}
