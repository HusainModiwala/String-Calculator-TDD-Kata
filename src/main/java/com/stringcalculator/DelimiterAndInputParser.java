package com.stringcalculator;


public class DelimiterAndInputParser {
    public static String[] parseDelimiter(String input) throws Exception {
        input = input.trim();
        if(input.isEmpty())return new String[]{",", ""};

        boolean hasDelimiter = input.startsWith("//");
        if(!hasDelimiter)return new String[]{",", input.trim()};

        int newlineIndex = input.indexOf('\n');

        if(newlineIndex != -1) {
            String delimiter =  input.substring(2, newlineIndex).trim();
            String numbers = input.substring(newlineIndex + 1).trim();

            return new String[]{delimiter, numbers};
        }
        throw new IllegalArgumentException("Delimiter ending not found");
    }
}
