package calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    private List<Integer> numbers;
    private List<String> symbols;

    public int performCalculation(String equation) {

        numbers =  getNumbers(equation);
        symbols = getMathSymbols(equation);

        addNumbers();

        return Objects.requireNonNullElse(numbers.get(0), 0);
    }

    private void addNumbers(){
        while (symbols.contains("+")){
            int index = symbols.indexOf("+");
            int result = numbers.get(index) + numbers.get(index+1);
            removeElements(index, result);
        }
    }

    private void removeElements(int index, int result){
        numbers.set(index, result);
        symbols.remove(index);
        numbers.remove(index+1);
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
