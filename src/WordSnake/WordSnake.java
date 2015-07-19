package WordSnake;

import java.util.ArrayList;
import java.util.Scanner;

public class WordSnake {

    /* TODO: Making the words align like a snake */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] wordArray = input.split(" ");

        for(int i = 0; i<wordArray.length; i++) {
            outputWords(wordArray, i);
        }
    }

    public static void outputWords(String[] words, int count) {
        String line = "";
        line = words[count];
        char[] verticalWord = line.toCharArray();

        if(count % 2 == 0) { System.out.print(line); }
        else {
            for(int i = 0, c = 1; c<line.length()-1;i++,c++) {


                System.out.print("\n" + whiteSpace(line.length()-1) + whiteSpace(line.length()-1) + verticalWord[c] );
            }


        }
    }

    public static String whiteSpace(int count) {
        String str = "";
        for(int i = 0; i<count;i++) {
            str += " ";
        }
        return str;
    }
}
