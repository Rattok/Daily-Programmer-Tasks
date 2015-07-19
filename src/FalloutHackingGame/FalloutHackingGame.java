package FalloutHackingGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FalloutHackingGame {

    int guessesLeft = 4;
    int difficulty = 0;
    String rightWord = "";
    int wordLength = 0;
    boolean gameWon = false;

    public static void main (String[] args) {
        FalloutHackingGame game = new FalloutHackingGame();
        game.startGame();

    }

    public void startGame() {
        Scanner input = new Scanner(System.in);
        System.out.println("Difficulty (1-5) ? ");
        Random rng = new Random();
        ArrayList<String> wordList = new ArrayList<>();
        int diffLevel = input.nextInt();
        int amountWords = diffLevel*4;

        try {
            wordList = createWordList();


        } catch(IOException e) {
            e.printStackTrace();

        }
        int i = 0;
        switch(diffLevel) {
            case 1:
                Random rngNumber1 = new Random();
                int randomRightNumber1 = rngNumber1.nextInt(4);
                wordLength = 4;
                while(i<amountWords) {
                    int number = rng.nextInt(wordList.size());
                    String word = wordList.get(number);
                    if(i == randomRightNumber1) {
                        rightWord = word;
                    }
                    wordList.remove(number);
                    if(word.length() == wordLength) {
                        i++;
                        System.out.println(word.toUpperCase());
                    }

                }
                break;

            case 2:
                Random rngNumber2 = new Random();
                int randomRightNumber2 = rngNumber2.nextInt(8);
                wordLength = 6;
                while(i<amountWords) {
                    int number = rng.nextInt(wordList.size());
                    String word = wordList.get(number);
                    if(i == randomRightNumber2) {
                        rightWord = word;
                    }
                    wordList.remove(number);
                    if(word.length() == wordLength) {
                        System.out.println(word.toUpperCase());
                        i++;
                    }

                }
                break;

            case 3:
                Random rngNumber3 = new Random();
                int randomRightNumber3 = rngNumber3.nextInt(12);
                wordLength = 9;
                while(i<amountWords) {
                    int number = rng.nextInt(wordList.size());
                    String word = wordList.get(number);
                    if(i == randomRightNumber3) {
                        rightWord = word;
                    }
                    wordList.remove(number);
                    if(word.length() == wordLength) {
                        i++;
                        System.out.println(word.toUpperCase());
                    }

                }
                break;

            case 4:
                Random rngNumber4 = new Random();
                int randomRightNumber4 = rngNumber4.nextInt(16);
                wordLength = 11;
                while(i<amountWords) {
                    int number = rng.nextInt(wordList.size());
                    String word = wordList.get(number);
                    if(i == randomRightNumber4) {
                        rightWord = word;
                    }
                    wordList.remove(number);
                    if(word.length() == wordLength) {
                        i++;
                        System.out.println(word.toUpperCase());
                    }

                }
                break;

            case 5:
                Random rngNumber5 = new Random();
                int randomRightNumber5 = rngNumber5.nextInt(20);
                wordLength = 13;
                while(i<amountWords) {
                    int number = rng.nextInt(wordList.size());
                    String word = wordList.get(number);
                    if(i == randomRightNumber5) {
                        rightWord = word;
                    }
                    wordList.remove(number);
                    if(word.length() == wordLength) {
                        i++;
                        System.out.println(word.toUpperCase());
                    }

                }
                break;

        }
        while(!gameWon) {
            System.out.println("Guess (" + guessesLeft + " left) ?");
            Scanner newInput = new Scanner(System.in);
            System.out.println("Right word: " + rightWord);
            String guessWord = newInput.nextLine();

            guessesLeft--;
            if(guessesLeft == 0) { System.out.println("Sry Bud, Shutting down your access. You have lost!"); break; }

            System.out.println(checkWord(guessWord.toUpperCase(), rightWord.toUpperCase()) + "/" + wordLength + " correct");

            if (checkWord(guessWord.toUpperCase(), rightWord.toUpperCase()) == wordLength) {
                System.out.println("You have won! You needed: " + (4 - guessesLeft) + " tries.");
                gameWon = true;
            }
        }


    }

    public ArrayList<String> createWordList() throws IOException {
        ArrayList<String> strings = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Paul/IdeaProjects/Daily Programmer Tasks/src/enable1.txt"))) {

            String line = br.readLine();

            while (line != null) {
                line = br.readLine();
                strings.add(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;

    }

    public int checkWord(String input, String word) {
        int correctCharacters = 0;
        char[] guessCharArray = input.toCharArray();
        char[] rightCharArray = word.toCharArray();


        for (int i = 0; i < guessCharArray.length; i++) {
            if (guessCharArray[i] == rightCharArray[i]) {
                correctCharacters++;
            }
        }

        return correctCharacters;
    }


}
