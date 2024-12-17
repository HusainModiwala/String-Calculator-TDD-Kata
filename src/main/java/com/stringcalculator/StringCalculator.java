package com.stringcalculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String input) {
        try {
            String[] delimiterAndInput = DelimiterAndInputParser.parseDelimiter(input);
            long sum = getSum(delimiterAndInput[0], delimiterAndInput[1]);

            return (int) sum;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static long getSum(String delimiter, String numbers) {
        String regex = Pattern.quote(delimiter) + "|\n";
        String[] numberArr = numbers.split(regex);

        long sum = 0;

        for(String num: numberArr) {
            String trimmedNumber = num.trim();
            if(!trimmedNumber.isEmpty()) {
                try{
                    sum += Long.parseLong(trimmedNumber);
                } catch (Exception e){
                    throw new IllegalArgumentException("Invalid number format: " + trimmedNumber);
                }
            }
        }
        return sum;
    }
}
