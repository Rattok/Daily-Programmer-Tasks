package FalloutHackingGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FalloutHackingGame {

    private static List<String> wordList;
    private static List<String> gameWordList;
    private static String winningWord;
    private static int guessesLeft = 4;
    private static int correctChars;
    private static Random rng;
    private static boolean gameEnd;

    public static void main(String[] args) {
        wordList = new ArrayList<>();
        gameWordList = new ArrayList<>();
        rng = new Random();
        populateList(wordList);

        System.out.println("Difficulty (1-5) ? ");
        int userDifficulty = new Scanner(System.in).nextInt();

        for(int i = 0; i<(userDifficulty*3);) {
            int randomNumber = rng.nextInt(wordList.size());
            if(wordList.get(randomNumber).length() == userDifficulty*3) {
                gameWordList.add(wordList.get(randomNumber).toUpperCase());
                i++;
            }
        }

        // Randomíze a word out of the given gamewordList
        winningWord = gameWordList.get(rng.nextInt(gameWordList.size()));

        // Print out the gameList of words
        for(String word : gameWordList) {
            System.out.println(word);
        }

        // For dev purposes
        System.out.println(winningWord);

        // Get the userInput as long as the game is not won and he has enough guesses
        while(!gameEnd && guessesLeft != 0) {
            gameLoop();
        }
    }

    public static void populateList(List<String> wordList) {

        try(BufferedReader in = new BufferedReader(new FileReader("enable1.txt"))) {
            String line;
            while(in.readLine() != null) {
                line = in.readLine();
                wordList.add(line.toUpperCase());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkUserInput(String userInput, String winningWord) {
        correctChars = 0;
        char[] userInputChars = userInput.toCharArray();
        char[] winningWordChars = winningWord.toCharArray();
        boolean gameWon = false;
        for(int i  = 0; i<winningWord.length(); i++) {
            if(userInputChars[i] == winningWordChars[i]) {
                correctChars++;
                if(correctChars == winningWordChars.length) { gameWon = true; }
            }
        }
        return gameWon;
    }

    public static void gameLoop() {
        System.out.println("Guess (" + guessesLeft + " left) ? ");
        String userInput = new Scanner(System.in).nextLine().toUpperCase();

        guessesLeft--;
        if(checkUserInput(userInput, winningWord)) {
            gameEnd = true;
            System.out.println(correctChars + "/" + winningWord.length() + " correct");
            System.out.println("YOU WIN!");
        } else if(guessesLeft == 0) {
            System.out.println("You have lost!");
        } else {
            System.out.println(correctChars + "/" + winningWord.length() + " correct");
        }
    }

}
