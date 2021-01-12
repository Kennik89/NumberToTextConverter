package codetest;

import com.main.NumberConverter;

public class Main {

    public static void main(String[] args) {
        NumberConverter converter = new NumberConverter();

        String output = converter.numberToWord("804018");
        System.out.println(output);
    }
}
