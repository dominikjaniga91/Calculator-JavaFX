package calculator.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    private List<Double> numbers;
    private List<String> symbols;

    public Number performCalculation(String equation) {

        numbers =  getNumbers(equation);
        symbols = getMathSymbols(equation);

        multiplyNumbers();
        divideNumbers();
        subtractNumbers();
        addNumbers();

        return getResult();
    }

    private Number getResult(){
        Number value = Objects.requireNonNullElse(numbers.get(0), 0);
        String temp = String.valueOf(value);
        return temp.endsWith(".0") ? value.intValue() : value;
    }

    private void multiplyNumbers(){
        while (symbols.contains("*")){
            int index = symbols.indexOf("*");
            double result = numbers.get(index) * numbers.get(index+1);
            removeElements(index, result);
        }
    }

    private void divideNumbers(){
        while (symbols.contains("/")){
            int index = symbols.indexOf("/");
            double result = numbers.get(index) / numbers.get(index+1);
            removeElements(index, result);
        }
    }

    private void subtractNumbers(){
        while (symbols.contains("-")){
            int index = symbols.indexOf("-");
            double result = numbers.get(index) - numbers.get(index+1);
            removeElements(index, result);
        }
    }

    private void addNumbers(){
        while (symbols.contains("+")){
            int index = symbols.indexOf("+");
            double result = numbers.get(index) + numbers.get(index+1);
            removeElements(index, result);
        }
    }

    private void removeElements(int index, double result){
        numbers.set(index, result);
        symbols.remove(index);
        numbers.remove(index+1);
    }

    protected List<Double> getNumbers(String equation) {

        String[] temp = equation.split("[^\\d.?]");
        return Stream.of(temp)
                .filter(number -> !number.isEmpty())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    protected List<String> getMathSymbols(String equation) {

        String[] temp = equation.split("[\\d]");
        return Stream.of(temp)
                .filter(sign -> !sign.isEmpty())
                .collect(Collectors.toList()) ;
    }
}
