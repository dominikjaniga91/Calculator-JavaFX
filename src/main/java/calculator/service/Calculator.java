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

    private List<Double> getNumbers(String equation) {

        String[] temp = equation.split("[^\\d.?]");
        System.out.println(Arrays.toString(temp));
        return Stream.of(temp)
                .filter(number -> !number.isEmpty())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
