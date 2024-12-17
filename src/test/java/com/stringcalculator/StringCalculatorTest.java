package com.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    // empty string test
    @Test
    public void addEmptyStringTest() {
        int actual = StringCalculator.add("");
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    // string with single no test
    @Test
    public void addOneNumberTest() {
        int actual = StringCalculator.add("1");
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    // string with two no test
    @Test
    public void addTwoNumbersTest() {
        int actual = StringCalculator.add("2,3");
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }

    // string with n no's test
    @Test
    public void addNNumbersTest() {
        int actual = StringCalculator.add("2,3,5,3,2,6,8,9,5");
        int expected = 43;
        Assert.assertEquals(expected, actual);
    }

    // string with n no's also having new line test
    @Test
    public void addNNumbersWithNewLineTest() {
        // "1\n2,3" should return 6
        int actual = StringCalculator.add("1\n2,3");
        int expected = 6;
        Assert.assertEquals(expected, actual);
    }

    // string with n no's also having new line, and may have custom delimiter test
    @Test
    public void addNNumbersWithNewLineAndCustomDelimiterTest() {
        // "//;\n1;2" should return 3
        int actual = StringCalculator.add("//;\n1;2");
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }

    // string with n no's also having n new lines, and may have custom delimiter (multiple times) test
    @Test
    public void addNNumbersWithNNewLineAndCustomDelimiterTest() {
        int actual = StringCalculator.add("//;\n 1 \n ; \n ; ; 2 \n ");
        int expected = 3;
        Assert.assertEquals(expected, actual);
    }

    // add with a negative number will throw an exception “negatives not allowed” - and the negative's that were passed.
    @Test
    public void addNNumbersWithNegativesTest() {
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            StringCalculator.add("//; \n2;-3 ;-2;1000 ");
        });

        String expectedMessage = "negatives not allowed: -3, -2";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }

    // numbers bigger than 1000 should be ignored, so adding 2 + 1001 = 2
    @Test
    public void addNNumbersWithSumLessThanThousandTest() {
        int actual = StringCalculator.add("//; \n2;3;2;1000 ");
        int expected = 7;
        Assert.assertEquals(expected, actual);
    }

    /* string with n no's also having n new lines, and may have custom delimiter with multiple chars also
     occurring more than once test */
    @Test
    public void addNNumbersWithNNewLineAndNCustomDelimiterTest() {
        int actual = StringCalculator.add("//;&,\n 1;&, \n ;&, \n  ;&, 2  ;&, 8 \n ");
        int expected = 11;
        Assert.assertEquals(expected, actual);
    }
}
