package HangMan;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {

    private static boolean gameWon = false;
    private static boolean guessHit = false;
    private static ArrayList<String> wordList = new ArrayList<>();
    private static int hitCount;
    private static int missCount;
    private static char[] correctChars;
    private static char[] blankChars;

    public static void main(String[] args) {
        Random rng = new Random();
        // Fill ArrayList with the dictionary-file
        fillWordList();
        // Choose a random word from the wordlist
        correctChars = wordList.get(rng.nextInt(wordList.size())).toCharArray();
        // Initialize the blankChars-Array with the same length as the correctWord split in chars
        blankChars = new char[correctChars.length];
        // Fill blankChars with blank spaces " _ "
        for(int i = 0; i<blankChars.length;i++) {
            blankChars[i] = '_';
        }
        System.out.println("----- Welcome to Hangman! -----\nThe correct word is: " + displayChars(correctChars));
        System.out.println("\n" + displayChars(blankChars) + "\n\nTake your guess!");
        // Get UserInput and convert it to a single char
        while(!gameWon) {
            Scanner input = new Scanner(System.in);
            char userInput = input.nextLine().charAt(0);
            // Check if the input is correct
            drawGallow(missCount);
            checkInput(userInput, correctChars, blankChars);
            if(hitCount == correctChars.length) {
                System.out.println("You have won! Good job!");
                gameWon = true;
            }
        }
    }

    public static void fillWordList() {
        try(BufferedReader in = new BufferedReader(new FileReader("enable1.txt"))) {
            String line = in.readLine();
            while(line != null) {
                line = in.readLine();
                wordList.add(line);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static String displayChars(char[] blankChars) {
        String blankChain = " ";
        for(int i = 0; i<blankChars.length;i++) {
            blankChain +=(" " + blankChars[i] + " ");
        }
        return blankChain;
    }

    public static void checkInput(char userInput, char[] correctChars, char[] blankChars) {
        for(int i = 0; i<correctChars.length;i++) {
            guessHit = false;
            if(correctChars[i] == userInput) {
                System.out.println("CORRECT!");
                hitCount++;
                guessHit = true;
                blankChars[i] = userInput;
            } else if(correctChars[i] != userInput && !guessHit) {
                System.out.println("FALSE!");
                guessHit = true;
                missCount++;
            }
        }
        System.out.println(displayChars(blankChars));

    }

    public static void drawGallow(int missCount) {
        String[] out = new String[6];
        out[0] = "     _____";

        for(int i = 1; i < out.length; i++)
            out[i] = "         |";

        if(missCount >= 1) {
            out[1] = "     |   |";
            out[2] = "     O   |";
        }
        if(missCount >= 2)
            out[3] = "     |   |";
        if(missCount >= 3)
            out[2] = "    \\O   |";
        if(missCount >= 4)
            out[1] = "   \\ |   |";
        if(missCount >= 5)
            out[2] = "    \\O/  |";
        if(missCount >= 6)
            out[1] = "   \\ | / |";
        if(missCount >= 7)
            out[4] = "    /    |";
        if(missCount >= 8)
            out[5] = "   /     |";
        if(missCount >= 9)
            out[4] = "    / \\  |";
        if(missCount >= 10)
            out[5] = "   /   \\ |";

        for(String s : out) {
            System.out.println(s);
        }

    }
}
