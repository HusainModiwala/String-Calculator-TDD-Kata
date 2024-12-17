package com.stringcalculator;

public class StringCalculator {

    public static int add(String numbers) {
        String delimiter = ",";
        String[] numberArr = numbers.split(delimiter);
        long sum = 0;

        for(String num: numberArr) {
            String trimmedNumber = num.trim();
            if(!trimmedNumber.isEmpty()) {
                try{
                    System.out.println(num);
                    String[] splitNewLine = trimmedNumber.split("\n");
                    int tempSum = 0;
                    for (String t : splitNewLine) {
                        String trimNumber = t.trim();
                        if (!trimNumber.isEmpty()) {
                            tempSum += Integer.parseInt(trimNumber);
                        }
                    }
                    if(tempSum > 0)sum+=tempSum;
                    else sum += Long.parseLong(num);
                } catch (Exception e){
                    throw new IllegalArgumentException("Invalid number format: " + trimmedNumber);
                }
            }
        }
        return (int) sum;
    }
}
