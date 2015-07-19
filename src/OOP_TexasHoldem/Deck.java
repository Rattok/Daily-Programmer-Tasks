package OOP_TexasHoldem;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    ArrayList<Integer> deck = new ArrayList<>();
    Card card1 = new Card();

    public void finalizeCarddeck() {
        for(int i = 0; i<52; i++) {
            deck.add(i);
        }
    }

    public String drawCard(ArrayList<Integer> deck) {
        Random random = new Random();
        int randomNumber = random.nextInt(deck.size());
        int card = deck.get(randomNumber);
        deck.remove(randomNumber);

        return card1.CARDVALUES[card%13] + " of " + card1.CARDSUITS[card/13];
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
