package ManglingSentences;

import java.text.Collator;
import java.util.*;

public class ManglingSentences {

    public static void main(String[] args) {

        ArrayList<String> wordList = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");

        for(String word : input) {
            char[] wordInChars = word.toCharArray();
            Arrays.sort(wordInChars);
            String sortedWord = new String(wordInChars);
            System.out.print(sortedWord + " ");

        }

    }

}
