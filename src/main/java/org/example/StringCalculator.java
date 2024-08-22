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
     * @param inputString
     * @return sumOfNumbers
     */
    public int addNumber(String inputString) {
        int sumOfNumbers = 0;

        if (inputString != null && !inputString.isEmpty()) {
            String delimiterPattern = "//(.*?)\n";
            Pattern pattern = Pattern.compile(delimiterPattern);
            Matcher matcher = pattern.matcher(inputString);

            String[] numbers;
            if (matcher.find()) {
                String delimiter = matcher.group(1);
                // Extract the rest of the string after the delimiter definition
                String data = inputString.split(delimiterPattern, 2)[1];  // Split into two parts: before and after pattern
                // Use the extracted delimiter to split the rest of the string
                numbers = data.split(delimiter);
            } else {
                numbers = inputString.split("[\\n,]");
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
