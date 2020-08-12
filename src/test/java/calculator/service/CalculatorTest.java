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
        List<String> expected = List.of("+","-","+");
        List<String> actual = calculator.getMathSymbols("5+4-2+4");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldReturnListWithNumbers(){
        List<Integer> expected = List.of(5,4,2,4);
        List<Integer> actual = calculator.getNumbers("5+4-2+4");
        Assertions.assertEquals(expected, actual);
    }
}
