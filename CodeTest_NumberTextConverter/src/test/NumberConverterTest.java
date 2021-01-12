package test;

import com.main.NumberConverter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class NumberConverterTest {
    NumberConverter converter = new NumberConverter();
    final int DOLLAR_MAX = 999999;
    final int CENT_MAX = 99;

    @Test
    void testBasisNumbers() {
        String output = "";

        output = converter.numberToWord("0");
        assertEquals("ZERO DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("1");
        assertEquals("ONE DOLLAR AND ZERO CENTS", output);

        output = converter.numberToWord("2");
        assertEquals("TWO DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("3");
        assertEquals("THREE DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("4");
        assertEquals("FOUR DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("5");
        assertEquals("FIVE DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("6");
        assertEquals("SIX DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("7");
        assertEquals("SEVEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("8");
        assertEquals("EIGHT DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("9");
        assertEquals("NINE DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("10");
        assertEquals("TEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("11");
        assertEquals("ELEVEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("12");
        assertEquals("TWELVE DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("13");
        assertEquals("THIRTEEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("14");
        assertEquals("FOURTEEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("15");
        assertEquals("FIFTEEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("16");
        assertEquals("SIXTEEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("17");
        assertEquals("SEVENTEEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("18");
        assertEquals("EIGHTEEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("19");
        assertEquals("NINETEEN DOLLARS AND ZERO CENTS", output);
    }

    @Test
    void testTenthNumbers() {
        String output = "";

        output = converter.numberToWord("20");
        assertEquals("TWENTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("30");
        assertEquals("THIRTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("40");
        assertEquals("FORTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("50");
        assertEquals("FIFTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("60");
        assertEquals("SIXTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("70");
        assertEquals("SEVENTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("80");
        assertEquals("EIGHTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("90");
        assertEquals("NINETY DOLLARS AND ZERO CENTS", output);
    }

    @Test
    void testComposeTwoDigits() {
        String output = "";

        output = converter.numberToWord("21");
        assertEquals("TWENTY ONE DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("44");
        assertEquals("FORTY FOUR DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("68");
        assertEquals("SIXTY EIGHT DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("99");
        assertEquals("NINETY NINE DOLLARS AND ZERO CENTS", output);
    }

    @Test
    void testHundredAndThousand() {
        String output = "";

        output = converter.numberToWord("100");
        assertEquals("ONE HUNDRED DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("600");
        assertEquals("SIX HUNDRED DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("315");
        assertEquals("THREE HUNDRED FIFTEEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("876");
        assertEquals("EIGHT HUNDRED SEVENTY SIX DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("1000");
        assertEquals("ONE THOUSAND DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("9097");
        assertEquals("NINE THOUSAND NINETY SEVEN DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("10000");
        assertEquals("TEN THOUSAND DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("29042");
        assertEquals("TWENTY NINE THOUSAND FORTY TWO DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("100000");
        assertEquals("ONE HUNDRED THOUSAND DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("320023");
        assertEquals("THREE HUNDRED TWENTY THOUSAND TWENTY THREE DOLLARS AND ZERO CENTS", output);
    }

    @Test
    void testLargeNumbers() {
        String output = "";

        output = converter.numberToWord("2190");
        assertEquals("TWO THOUSAND ONE HUNDRED NINETY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("2100");
        assertEquals("TWO THOUSAND ONE HUNDRED DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("35530");
        assertEquals("THIRTY FIVE THOUSAND FIVE HUNDRED THIRTY DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("35500");
        assertEquals("THIRTY FIVE THOUSAND FIVE HUNDRED DOLLARS AND ZERO CENTS", output);

        output = converter.numberToWord("999999");
        assertEquals("NINE HUNDRED NINETY NINE THOUSAND NINE HUNDRED NINETY NINE DOLLARS AND ZERO CENTS", output);
    }

    @Test
    void testWithCents() {
        String output = "";

        output = converter.numberToWord("1.01");
        assertEquals("ONE DOLLAR AND ONE CENT", output);

        output = converter.numberToWord("10.03");
        assertEquals("TEN DOLLARS AND THREE CENTS", output);

        output = converter.numberToWord("1.10");
        assertEquals("ONE DOLLAR AND TEN CENTS", output);

        output = converter.numberToWord("1.5");
        assertEquals("ONE DOLLAR AND FIFTY CENTS", output);

        output = converter.numberToWord("1.0");
        assertEquals("ONE DOLLAR AND ZERO CENTS", output);

        output = converter.numberToWord("0.66");
        assertEquals("ZERO DOLLARS AND SIXTY SIX CENTS", output);
    }

    @Test
    void testMisplacedDot() {

        String output = "";

        try {
            output = converter.numberToWord(".01");
            fail();
        } catch (IllegalArgumentException ignored) {
        } catch (Exception e) {
            fail("The expected exception was not thrown");
        }

        try {
            output = converter.numberToWord("20.");
            fail();
        } catch (Exception ignored) {}
        
    }

    @Test
    void testTooLongNumberOfCents() {
        String output = "";
        try {
            output = converter.numberToWord("0.123");
            fail();
        } catch (IllegalArgumentException ignored) {}
        
    }

    @Test
    void testNonNumberInput() {
        String output = "";
        try {
            output = converter.numberToWord("Hello world");
            fail();
        } catch (IllegalArgumentException ignored) {}

    }

    @Test
    void testByRandomGeneratorStringPattern() {
        int sampleCount = 10000;
        Random randomGenerator = new Random();
        List<String> listOfErrors = new ArrayList<>();

        int dollarValue, centValue;

        while (sampleCount > 0) {
            dollarValue = randomGenerator.nextInt(DOLLAR_MAX + 1);
            centValue = randomGenerator.nextInt(CENT_MAX + 1);
            String stringCentValue = centValue < 10 ? "0" + centValue : String.valueOf(centValue);
            String input = dollarValue + "." + stringCentValue;
            String output = converter.numberToWord(input);

            if (output.contains("  ")) {
                listOfErrors.add(input + " --double spaces in row-- " + output);
            }
            if (dollarValue >= 1000 && !output.contains("THOUSAND "))  {
                listOfErrors.add(input + " --Missing text of thousand-- " + output);
            }

            if (output.contains("NULL")) {
                listOfErrors.add(input + " --null in output-- " + output);
            }
            if (dollarValue == 1 && output.contains("DOLLARS")) {
                listOfErrors.add(input + " --Grammar error in dollar-- " + output);
            }

            if ("01".equals(stringCentValue) && output.contains("CENTS") || !"01".equals(stringCentValue) && !output.contains("CENTS")) {
                listOfErrors.add(input + " --Grammar error in cent-- " + output);
            }

            sampleCount--;
        }

        if (!listOfErrors.isEmpty()) {
            listOfErrors.sort(String::compareToIgnoreCase);
            listOfErrors.forEach(System.out::println);
            fail();
        }
    }
}