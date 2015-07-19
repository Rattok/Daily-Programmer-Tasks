package DeckOfCards;

public class Card {

    private String rank;
    private String suit;
    private String colour;
    private int value;


    public Card(String rank, String suit, String colour, int value)  {
        this.rank = rank;
        this.suit = suit;
        this.colour = colour;
        this.value = value;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
