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

    // string with n no test
    @Test
    public void addNNumbersTest() {
        int actual = StringCalculator.add("2,3,5,3,2,6,8,9,5");
        int expected = 43;
        Assert.assertEquals(expected, actual);
    }
}
