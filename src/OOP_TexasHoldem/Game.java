package OOP_TexasHoldem;

import java.util.Scanner;

public class Game {

    int playerCount;
    Deck deck1 = new Deck();
    public static void main(String[] args) {
        Game game1 = new Game();
        game1.startGame();

    }

    public void startGame() {

        System.out.println("How many players (2-8) ? :");
        Scanner input = new Scanner(System.in);
        playerCount = input.nextInt();
        deck1.finalizeCarddeck();

        deck1.dealCards("Your hand: ", deck1.deck, 2);

        for(int i = 0, c=1; i<playerCount;i++,c++) {
            deck1.dealCards("CPU " + c + " Hand: ", deck1.deck, 2);
        }
        deck1.dealCards("Flop: ", deck1.deck, 3);
        deck1.dealCards("Turn: ", deck1.deck, 1);
        deck1.dealCards("River: ", deck1.deck, 1);
    }
}
