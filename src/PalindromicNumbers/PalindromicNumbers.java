package PalindromicNumbers;

import java.math.BigInteger;
import java.util.Scanner;

public class PalindromicNumbers {

    /*
    Todo:
    - Use StringBuilder's integrated method reverse() to reverse a string
    - Optimize code for improved readibility
    */

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Please input a number...");
        String userInput = input.nextLine();
        long count = 0;
        String reverseString = reverseString(userInput);

        BigInteger number1, number2, sum;

        while(!isPalindromic(userInput, reverseString)) {
            number1 = new BigInteger(userInput);
            number2 = new BigInteger(reverseString);
            sum = number1.add(number2);
            System.out.println(sum);
            count++;
            if(count > 10000) { System.out.println("Woops. too big ;)"); break;}
            userInput = sum.toString();
            reverseString = reverseString(userInput);

        }
        if(count <8000)System.out.println("The number " + userInput + " gets palindromic after " + count + " times.");
    }

    public static String reverseString(String userInput) {
        String reverseString = "";
        for(int i = userInput.length()-1; i>=0; i--) {
            reverseString += userInput.charAt(i);
        }
        return reverseString;
    }

    public static boolean isPalindromic(String orig, String rev) {

        return orig.equals(rev);
    }


}
