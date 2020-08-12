package calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource({
            "5-6*4+2-1, -18",
            "2+4-3*2-4, -4",
            "6*3+2-1, 19",
            "2*8-6*2+3, 7",
    })
    void shouldReturnAppropriateResult_afterPerformCalculation(String equation, int expected){
        int actual = calculator.performCalculation(equation);
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
