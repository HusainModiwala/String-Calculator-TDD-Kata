package com.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {
    @Test
    public void addEmptyStringTest() {
        int actual = StringCalculator.add("");
        int expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addOneNumberTest() {
        int actual = StringCalculator.add("1");
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addTwoNumbersTest() {
        int actual = StringCalculator.add("2,3");
        int expected = 5;
        Assert.assertEquals(expected, actual);
    }
}
