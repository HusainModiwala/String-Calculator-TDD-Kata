package com.stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String numbers) {
        String delimiter = parseDelimiter(numbers);
        //String regex = "[\n]"; //this shall handle both "," and "\n" at once to avoid nested loop.
        String regex = "[" + Pattern.quote(delimiter) + "\n]";
        String[] numberArr = numbers.split(regex);
        long sum = 0;

        for(String num: numberArr) {
            String trimmedNumber = num.trim();
            if(!trimmedNumber.isEmpty()) {
                try{
                    sum += Long.parseLong(num);
                } catch (Exception e){
                    throw new IllegalArgumentException("Invalid number format: " + trimmedNumber);
                }
            }
        }
        return (int) sum;
    }

    public static String parseDelimiter(String input) {
        input = input.trim();
        if(input.isEmpty())return ",";

        boolean hasDelimiter = input.startsWith("//");
        if(!hasDelimiter)return ",";

        int newlineIndex = input.indexOf('\n');

        if(newlineIndex != -1) return input.substring(2, newlineIndex).trim();
        return ",";
    }
}
