package com.stringcalculator;

public class StringCalculator {

    public static int add(String numbers) {
        String regex = "[,\n]"; //this shall handle both "," and "\n" at once to avoid nested loop.
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
}
