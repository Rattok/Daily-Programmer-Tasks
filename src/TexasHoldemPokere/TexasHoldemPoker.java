package TexasHoldemPokere;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TexasHoldemPoker {

    public static final String[] CARDVALUES = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    public static final String[] CARDSUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    int playerCount;
    ArrayList<Integer> deck = new ArrayList<>();

    public void finalizeCarddeck() {
        for(int i = 0; i<52; i++) {
            deck.add(i);
        }
    }

    public void startGame() {

        System.out.println("How many players (2-8) ? :");
        Scanner input = new Scanner(System.in);
        playerCount = input.nextInt();
        finalizeCarddeck();

        dealCards("Your hand: ", deck, 2);

        for(int i = 0, c=1; i<playerCount;i++,c++) {
            dealCards("CPU " + c + " Hand: ", deck, 2);

        }
        dealCards("Flop: ", deck, 3);
        dealCards("Turn: ", deck, 1);
        dealCards("River: ", deck, 1);
    }

    public String drawCard(ArrayList<Integer> deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.size());
        int card = deck.get(randomNumber);
        deck.remove(randomNumber);

        return CARDVALUES[card%13] + " of " + CARDSUITS[card/13];
    }

    public void dealCards(String player, ArrayList<Integer> deck, int drawCount) {

        System.out.print(player + " ");
        for(int i = 0; i < drawCount;i++) {
            System.out.print(drawCard(deck));
            if(i < drawCount-1) {
                System.out.print(", ");
            }
        }
        System.out.println("");

    }
}
