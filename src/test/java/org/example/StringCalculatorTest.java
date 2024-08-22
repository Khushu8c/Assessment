package org.example;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static java.lang.Integer.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

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
        int expectedSum = 6;
        assertEquals(expectedSum, stringCalculator.addNumber("1,5"));
    }


}
