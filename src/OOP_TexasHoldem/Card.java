package OOP_TexasHoldem;

import java.util.ArrayList;


public class Card {

    public static final String[] CARDVALUES = {"Ace", "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
    public static final String[] CARDSUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};


    ArrayList<String> cardPriority = new ArrayList<>();
    ArrayList<String> cardPairing = new ArrayList<>();

    public void setCardPriority() {

        for(int i = 0; i<CARDVALUES.length;i++) {
            cardPriority.add(CARDVALUES[i]);
        }
    }

    public void setCardPairing() {

        for(int i = 0; i<CARDVALUES.length;i++) {
            cardPriority.add(CARDVALUES[i]);
        }
    }


}
