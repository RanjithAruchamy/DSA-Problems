package leetcode.easy;

import java.util.Map;

public class RomanToInt {
    private final static Map<String, Integer> ROMAN_SYMBOL_AND_VALUE = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    public static int romanToInt(String s) {
        String[] individualDigitsOfRomanValues = s.split("");
        int result = 0;

        for (int i = individualDigitsOfRomanValues.length - 1; i >= 0; i--) {
            int currentValue = ROMAN_SYMBOL_AND_VALUE.get(individualDigitsOfRomanValues[i]);

            if (i < individualDigitsOfRomanValues.length - 1) {
                int previousValue = ROMAN_SYMBOL_AND_VALUE.get(individualDigitsOfRomanValues[i + 1]);
                if (currentValue < previousValue) {
                    result = result - currentValue;
                    continue;
                }
            }
            result = result + currentValue;
        }
        return result;
    }

    public static void main(String[] args) {
        assert 3 == romanToInt("III");
        assert 58 == romanToInt("LVIII");
        assert 1994 == romanToInt("MCMXCIV");
    }

}
