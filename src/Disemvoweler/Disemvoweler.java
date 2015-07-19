package Disemvoweler;

import java.util.Scanner;

public class Disemvoweler {

    /* TODO: Instead of using char arrays use the method contains() of String */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();
        String vowels = "";
        String[] disemvoweledWord = input.split("[aeiou\\ ]");
        
        for(int i = 0; i<input.length(); i++) {
            if(inputArray[i] == 'a' || inputArray[i] == 'e' || inputArray[i] == 'i' || inputArray[i] == 'o' || inputArray[i] == 'u') {
                vowels += inputArray[i];
            }
        }

        for(String word : disemvoweledWord) {
            System.out.print(word);
        }
        System.out.print("\n" + vowels);
    }
}
