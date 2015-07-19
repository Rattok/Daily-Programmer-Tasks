package BlackJackChecker;

import java.util.Scanner;

public class BlackjackChecker {



    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("How many players ");
        int playerCount = input.nextInt();
        System.out.println("The name of the players and their cards in their hand: ");
        for(int i = 0; i<playerCount;i++) {
            Scanner input1 = new Scanner(System.in);
            String nameAndCards = input1.nextLine();
            String playername = nameAndCards.split(":")[0];
            System.out.println("Playername = " + playername);
            Player player = new Player(playername);
            System.out.println(player.getName() + " added");
        }

    }
}
