package RPSLP;

import java.util.Random;
import java.util.Scanner;

public class RPSLPGame {

    private static final String[] moves = {"Rock", "Paper", "Lizard", "Spock", "Scissors"};
    private static int gamesPlayed;
    private static int winningCount;
    private static int tieCount;
    private static int lossCount;
    private static String winningMove;
    private static boolean gameEnd;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("-----Player, please pick your preffered Option: Lizard, Rock, Paper, Scissors or Spock-----");
        System.out.println("Type \"END\" or \"E\" to quit the game.");
        while(!gameEnd) {
            System.out.println("Your input: ");
            String computerPick = moves[random.nextInt(5)];
            String playerPick = scanner.nextLine();

            // In case player wants to exit the gameloop
            if(playerPick.toLowerCase().equals("end") || playerPick.toLowerCase().equals("e") ) {
                System.out.println("You have chosen to end the game! Exiting now...");
                gameEnd = true;
                break;

            // If the input is some of the valid choices, execute the winning condition method
            } else if(playerPick.equalsIgnoreCase("scissors") || playerPick.equalsIgnoreCase("lizard") || playerPick.equalsIgnoreCase("rock")
                      || playerPick.equalsIgnoreCase("paper") || playerPick.equalsIgnoreCase("spock")) {

                System.out.println("User picks: " + playerPick);
                System.out.println("Computer picks: " + computerPick);
                System.out.println(winningCondition(playerPick.toLowerCase(), computerPick.toLowerCase()));
                gamesPlayed++;
                double percentage = (double) winningCount/gamesPlayed;
                System.out.println("Wins: " + winningCount + " Losses: " + lossCount + " Ties: " + tieCount + " Percentage: " + percentage + "\n");

            } else { System.out.println("Please choose one of the valid options stated above, your input was wrong...\n"); }
        }
    }

    public static String winningCondition(String playerPick, String computerPick) {
        String winningSentence = "";
        String whoWins = "";

        if(playerPick.equals("scissors") && computerPick.equals("paper") || playerPick.equals("paper") && computerPick.equals("scissors")) {
            winningMove = "scissors";
            winningSentence = "Scissors cuts Paper\n";
        }
        if(playerPick.equals("scissors") && computerPick.equals("lizard") || playerPick.equals("lizard") && computerPick.equals("scissors")) {
            winningMove = "scissors";
            winningSentence = "Scissors decapitates Lizard\n";
        }

        if(playerPick.equals("spock") && computerPick.equals("scissors") || playerPick.equals("scissors") && computerPick.equals("spock")) {
            winningMove = "spock";
            winningSentence = "Spock smashes Scissors\n";
        }
        if(playerPick.equals("spock") && computerPick.equals("rock") || playerPick.equals("rock") && computerPick.equals("spock")) {
            winningMove = "spock";
            winningSentence = "Spock vaporizes Rock\n";
        }

        if(playerPick.equals("lizard") && computerPick.equals("spock") || playerPick.equals("spock") && computerPick.equals("lizard")) {
            winningMove = "lizard";
            winningSentence = "Lizard poisons Spock\n";
        }
        if(playerPick.equals("lizard") && computerPick.equals("paper") || playerPick.equals("paper") && computerPick.equals("lizard")) {
            winningMove = "lizard";
            winningSentence = "Lizard eats Paper\n";
        }

        if(playerPick.equals("rock") && computerPick.equals("lizard") || playerPick.equals("lizard") && computerPick.equals("rock")) {
            winningMove = "rock";
            winningSentence = "Rock crushes Lizard\n";
        }
        if(playerPick.equals("rock") && computerPick.equals("scissors") || playerPick.equals("scissors") && computerPick.equals("rock")) {
            winningMove = "rock";
            winningSentence = "Rock crushes Scissors\n";
        }

        if(playerPick.equals("paper") && computerPick.equals("spock") || playerPick.equals("spock") && computerPick.equals("paper")) {
            winningMove = "paper";
            winningSentence = "Paper disproves Spock\n";
        }
        if(playerPick.equals("paper") && computerPick.equals("rock") || playerPick.equals("rock") && computerPick.equals("paper")) {
            winningMove = "paper";
            winningSentence = "Paper covers Rock\n";
        }
        if(playerPick.equals(winningMove)) {
            winningCount++;
            whoWins = "Player wins!";
        }
        if (!playerPick.equals(winningMove)) {
            lossCount++;
            whoWins = "Computer wins!";
        }

        if(playerPick.equals(computerPick)) {
            tieCount++;
            whoWins = "Tied! You both had the same idea, better luck next time!";
        }

        return whoWins + "\n" + winningSentence;
    }
}
