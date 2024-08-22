package org.example;

public class StringCalculator {

    public int addNumber(String numbersString) {
        int sumOfNumbers = 0;
        if (numbersString == null || numbersString.isEmpty()) {
            return sumOfNumbers;
        } else {
            int length = numbersString.length();
            if (length == 1) {
                sumOfNumbers = Integer.parseInt(numbersString);
            } else {
                String[] numbers = numbersString.split("[\\n,]");
                for (int i = 0; i < numbers.length; i++) {
                    sumOfNumbers = sumOfNumbers + Integer.parseInt(numbers[i]);
                }
            }
        }
        return sumOfNumbers;
    }

}
