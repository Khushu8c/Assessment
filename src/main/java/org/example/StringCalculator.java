package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * The {@code StringCalculator} class provides basic arithmetic operations on String.
 * It support addition of input string.
 * <p>
 * Example usage:
 * <pre>
 *     StringCalculator stringCalculator = new StringCalculator();
 *     int sum = stringCalculator.addNumber("5,3");
 * </pre>
 * </p>
 *
 * @author Soniya Patel
 * @version 1.0
 */
public class StringCalculator {

    /**
     * This method support addition of numbers in given string.
     * Comma(,), new line character (\n) can be used as separator. ex: "1,5", "1\n5\n2", "1\n5,3"
     * Support of dynamic separator For ex: "//:\n1:2", "//;\n2;3"
     *
     * @param numbersString
     * @return sumOfNumbers
     */
    public int addNumber(String numbersString) {
        int sumOfNumbers = 0;

        if (numbersString != null && !numbersString.isEmpty()) {
            String delimiterPattern = "//(.)\n";
            Pattern pattern = Pattern.compile(delimiterPattern);
            Matcher matcher = pattern.matcher(numbersString);

            String[] numbers;
            if (matcher.find()) {
                // replace the delimiter character with whole pattern
                String delimiter = numbersString.replaceFirst(delimiterPattern, "$1");
                char c = delimiter.charAt(0);
                numbers = numbersString.split(delimiterPattern)[1].split(String.valueOf(c)); // Splits based on delimiter
            } else {
                numbers = numbersString.split("[\\n,]");
            }
            List<Integer> negativeNumber = new ArrayList<>();
            for (String s : numbers) {
                int number = Integer.parseInt(s.trim());

                if (number < 0) {
                    negativeNumber.add(number);
                }
            }
            if (negativeNumber.isEmpty()) {
                for (String s : numbers) {
                    int number = Integer.parseInt(s.trim());
                    sumOfNumbers = sumOfNumbers + number;
                }
            } else {
                throw new RuntimeException("negative numbers  not allowed : " + negativeNumber);
            }
        }
        return sumOfNumbers;
    }

}
