package calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {


    public int performCalculation(String equation) {

        int result = 0;

        if (equation.contains("+")){
            String[] numbers = equation.split("\\+");
            result = Integer.parseInt(numbers[0]) +  Integer.parseInt(numbers[1]);
        }

        return result;
    }

    protected List<Integer> getNumbers(String equation) {

        String[] temp = equation.split("[^\\d.?]");
        System.out.println(Arrays.toString(temp));
        return Stream.of(temp)
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    protected List<String> getMathSymbols(String equation) {

        String[] temp = equation.split("[\\d]");
        return Stream.of(temp)
                .filter(sign -> !sign.isEmpty())
                .collect(Collectors.toList()) ;
    }
}
