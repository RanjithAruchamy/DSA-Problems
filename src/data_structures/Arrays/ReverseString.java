package data_structures.Arrays;

public class ReverseString {
    
    public static String reverseString(String inputString) {
        String[] splittedString = inputString.split("");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = splittedString.length - 1; i >= 0; i--) {
            stringBuilder.append(splittedString[i]);
        }
        return stringBuilder.toString();
    }

    public static String reverseString1(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }

    public static String recursiveReversal (String str) {
        if (str.isEmpty())  //breakpoint for recursion
            return "";
        return recursiveReversal(str.substring(1)) + str.charAt(0);
    }
    
    public static void main(String[] args) {
        System.out.println(recursiveReversal(recursiveReversal("Hi I'm Ranjith!")));
    }
}
