package org.example;

public class StringCalculator {

    public int addNumber(String numbersString) {
        int sumOfNumbers = 0;
        if (numbersString == null || numbersString.isEmpty()) {
        } else {
            int length = numbersString.length();
            if (length == 1) {
                sumOfNumbers = Integer.parseInt(numbersString);
            }
        }
        return sumOfNumbers;
    }

}
