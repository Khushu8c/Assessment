package org.example;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public  void setUp() {
        stringCalculator = new StringCalculator();
    }
    @Test
    public void shouldReturnZeroForNullOrEmptyString() {
        int sum = stringCalculator.addNumber("");
        Assert.assertEquals("For empty or null string method should return 0", 0, sum);
    }


}
