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
    public int performCalculation(String inputString) {
        int result = 0;

        if (inputString != null && !inputString.isEmpty()) {
            String delimiter = findDelimiter(inputString);

            System.out.println("delimiter: " + delimiter);

            String[] numbers = findNumbers(inputString, delimiter);

            checkForNegativeNumbers(numbers);

            if (delimiter!= null && delimiter.contains("*")) {
                result = getMultiplyOfNumbers(numbers);
            } else {
                result = getSumOfNumbers(numbers);
            }
        }
        return result;
    }

    private static int getSumOfNumbers(String[] numbers) {
        int sumOfNumbers = 0;
        for (String number: numbers) {
            sumOfNumbers = sumOfNumbers + Integer.parseInt(number);
        }
        return sumOfNumbers;
    }

    private static int getMultiplyOfNumbers(String[] numbers) {
        int productOfNumbers = 1;
        for (String number: numbers) {
            productOfNumbers = productOfNumbers * Integer.parseInt(number);
        }
        return productOfNumbers;
    }

    private static void checkForNegativeNumbers(String[] numbers) {
        List<Integer> negativeNumber = new ArrayList<>();
        for (String s : numbers) {
            int number = Integer.parseInt(s.trim());

            if (number < 0) {
                negativeNumber.add(number);
            }
        }

        if (!negativeNumber.isEmpty()) {
            throw new RuntimeException("negative numbers  not allowed : " + negativeNumber);
        }
    }

    private static String findDelimiter(String inputString) {
        String delimiter = null;

        String delimiterPattern = "//(.*?)\n";
        Pattern pattern = Pattern.compile(delimiterPattern);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            delimiter = matcher.group(1);
            if (delimiter.equalsIgnoreCase("*")) {
                delimiter = "\\*";
            }
        }
        return delimiter;
    }

    private static String[] findNumbers(String numberString, String delimiter) {
        String[] numbers;

        if (numberString.contains("//") || numberString.contains("*")) {
            numberString = numberString.substring(numberString.indexOf("\n") + 1);
        }

        if (delimiter != null) {
            // Use the extracted delimiter to split the rest of the string
            numbers = numberString.split(delimiter);
        } else {
            //use the default delimiter character to split
            numbers = numberString.split("[\\n,]");
        }
        return numbers;
    }

}
