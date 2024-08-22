package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                String delimiterPattern = "//(.)\n";
                Pattern pattern = Pattern.compile(delimiterPattern);
                Matcher matcher = pattern.matcher(numbersString);

                String[] numbers;
                if (matcher.find()) {
                    String delimiter = numbersString.replaceFirst(delimiterPattern, "$1");  // Extracts the delimiter
                    char c = delimiter.charAt(0);
                    numbers = numbersString.split(delimiterPattern)[1].split(String.valueOf(c)); // Splits based on delimiter
                } else {
                    numbers = numbersString.split("[\\n,]");
                }
                List<Integer> negativeNumber = new ArrayList<>();
                for (int i = 0; i < numbers.length; i++) {
                    int number = Integer.parseInt(numbers[i].trim());

                    if (number < 0) {
                        negativeNumber.add(number);
                    }

                    sumOfNumbers = sumOfNumbers + number;
                }
                if (!negativeNumber.isEmpty()) {
                    throw new RuntimeException("negative numbers  not allowed : " + negativeNumber);
                }

            }
        }
        return sumOfNumbers;
    }

}
