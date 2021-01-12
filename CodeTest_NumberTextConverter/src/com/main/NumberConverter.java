package com.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class NumberConverter {

    protected final Map<Integer, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        String input;
        NumberConverter converter = new NumberConverter();

        do {
            System.out.print("Enter a number: ");
            input = new Scanner(System.in).nextLine();
            if (!"".equals(input)) {
                System.out.println(converter.numberToWord(input));
                System.out.println();
            }

        } while (!input.equals(""));
    }

    public NumberConverter() {

        try {
            InputStream inputStream = getClass().getResourceAsStream("translations.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                String[] line = reader.readLine().split(" - ");
                int key = Integer.parseInt(line[0]);
                dictionary.put(key, line[1]);
            }
            inputStream.close();
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String numberToWord(String input) {
        StringBuilder output = new StringBuilder();
        String[] splitInput = splitAndValidateInput(input);

        output.append(buildTextByNumber(splitInput[0], ValueType.DOLLAR));
        output.append(" AND ");
        if (splitInput.length > 1) {
            if (splitInput[1].length() == 1) {
                splitInput[1] = splitInput[1] + "0";
            }
            output.append(buildTextByNumber(splitInput[1], ValueType.CENT));
        } else {
            output.append("ZERO ").append(ValueType.CENT.text).append("S");
        }

        return output.toString().toUpperCase();
    }

    private String[] splitAndValidateInput(String input) {

        //Validate the entire input
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input should not be blank");
        } else if (input.charAt(input.length() - 1) == '.') {
            throw new IllegalArgumentException("Insert a number is required after the dot");
        }

        String[] splitInput = input.split("\\.");
        if (splitInput.length < 1 || splitInput.length >= 3) {
            throw new NumberFormatException("Input must only contain one or zero dots");
        }

        // Validate of dollar input
        int dollarNumber;
        dollarNumber = Integer.parseInt(splitInput[0]); // Throw an exception when dollarNumber is not a number

        if (dollarNumber < 0 || dollarNumber >= 1000000) {
            throw new IllegalArgumentException("Dollar input is out of boundary");
        }

        // Validate of cent input
        if (splitInput.length == 2) {
            int centNumber;
            centNumber = Integer.parseInt(splitInput[1]); // Throw an exception when centInput is not a number

            if (centNumber < 0 || centNumber >= 100) {
                throw new IllegalArgumentException("Cent input is out of boundary");
            }
        }

        return splitInput;
    }

    private String buildTextByNumber(String input, ValueType type)  {
        StringBuilder print = new StringBuilder();
        int inputNumber = Integer.parseInt(input);
        String numberByWords = dictionary.get(inputNumber);

        if (numberByWords == null) {
            String[] arrayOfTriDigit = splitEquallyByThree(input);

            for (int i = 0; i < arrayOfTriDigit.length; i++) {
                String nextString = getTextByNumber(arrayOfTriDigit[i]);
                if (nextString != null) {
                    print.append(nextString);
                    if (arrayOfTriDigit.length - i == 2) {
                        print.append("THOUSAND").append(" ");
                    }
                }
            }

        } else {
            print.append(numberByWords).append(" ");
        }

        print.append(type.text);
        if (inputNumber != 1) {
            print.append("S");
        }

        return print.toString();
    }

    private String getTextByNumber(String input) {
        if (input.isEmpty()) {
            return null;
        }
        int inputNumber = Integer.parseInt(input);
        String outputText = dictionary.get(inputNumber);

        if (outputText != null) {
            if (inputNumber == 0) { // To avoid "zero" ie. 10 should not return "TEN ZERO"
                return null;
            } else {
                return outputText + " ";
            }
        } else {
            StringBuilder composeText = new StringBuilder();

            switch (input.length()) {
                case 3:
                    if (!"0".equals(input.substring(0, 1))) {
                        composeText.append(getTextByNumber(input.substring(0, 1)));
                        composeText.append("HUNDRED").append(" ");
                    }
                    if (!"00".equals(input.substring(1, 3))) {
                        composeText.append(getTextByNumber(input.substring(1, 3)));
                    }
                    break;
                case 2:
                    composeText.append(getTextByNumber(input.charAt(0) + "0"));
                    composeText.append(getTextByNumber(input.substring(1)));
                    break;
            }

            return composeText.toString();
        }
    }

    String[] splitEquallyByThree(String text) {
        ArrayList<String> stringArrayList = new ArrayList<>();

        int index = text.length();
        while (index > 0) {
            stringArrayList.add(text.substring(Math.max(0, index - 3), index));
            index = index - 3;
        }
        Collections.reverse(stringArrayList);

        String[] array = new String[stringArrayList.size()];
        array = stringArrayList.toArray(array);

        return array;
    }
}

enum ValueType {
    DOLLAR("DOLLAR"),
    CENT("CENT");

    public final String text;

    ValueType(String text) {
        this.text = text;
    }
}
