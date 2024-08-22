package org.example;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static java.lang.Integer.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public  void setUp() {
        stringCalculator = new StringCalculator();
    }
    @Test
    public void returnZeroOnEmptyOrNullString() {
        int sum = stringCalculator.addNumber("");
        assertEquals( 0, sum);
    }

    @Test
    public void returnNumberItselfOnInputStringHasSingleNumber() {
        String input = "1";
        int sum = stringCalculator.addNumber(input);
        assertEquals(parseInt(input), sum);
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionOnInvalidInput() {
        stringCalculator.addNumber("a");
    }

    @Test
    public void shouldReturnSumOfGivenForMultipleNumberGivenAsInput() {
        assertEquals(6, stringCalculator.addNumber("1,5"));
        assertEquals(8, stringCalculator.addNumber("1,5,2"));
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowExceptionOnMultipleInvalidInput() {
        stringCalculator.addNumber("1,a");
    }

    @Test
    public void shouldReturnSumForGivenInputOnCommaOrNewLineAsDelimeter() {
        assertEquals(6, stringCalculator.addNumber("1,5"));
        assertEquals(8, stringCalculator.addNumber("1\n5\n2"));
        assertEquals(9, stringCalculator.addNumber("1\n5,3"));
    }

    @Test
    public void dynamicDelimeterShouldSupportAndShouldReturnSum() {
        assertEquals(3, stringCalculator.addNumber("//:\n1:2"));
        assertEquals(5, stringCalculator.addNumber("//;\n2;3"));
    }

    @Test
    public void onNegativeNumberAsInputExceptionShouldThrowWithProperErrorMessage() {

        thrown.expect(RuntimeException.class);
        thrown.expectMessage("negative numbers  not allowed : [-5, -2]");

        stringCalculator.addNumber("1,-5,-2");
    }
}
