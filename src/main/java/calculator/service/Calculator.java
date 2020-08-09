package calculator.service;

public class Calculator {


    public int performCalculation(String equation) {

        int result = 0;

        if (equation.contains("+")){
            String[] numbers = equation.split("\\+");
            result = Integer.parseInt(numbers[0]) +  Integer.parseInt(numbers[1]);
        }

        return result;
    }
}
