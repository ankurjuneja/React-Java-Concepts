package ArraysAndStrings;

import java.util.Arrays;

public class Deck {

    private String[] SUITS;
    private String[] RANKS;
    private String[] DECK;
    private int numOfCards;

    public Deck(){
        this.SUITS = new String[] {
                "Clubs","Diamonds","Hearts","Spades"
        };

        this.RANKS = new String[] {
                "2","3","4","5","6","7","8","9",
                "Jack","Queen","King","Ace"
        };

        //initalize the deck
        numOfCards = SUITS.length * RANKS.length;
        DECK = new String[numOfCards];

        for(int i=0; i<RANKS.length; i++){
            for(int j=0; j<SUITS.length; j++) {
                DECK[SUITS.length*i +j] = RANKS[i] + " of " + SUITS[j];
            }
        }
    }

    //shuffle deck
    public void shuffleDeck() {
        for (int i=0; i<numOfCards; i++) {
            int rand = i + (int) (Math.random() * (numOfCards-i));

            //swap
            String temp = DECK[rand];
            DECK[rand] = DECK[i];
            DECK[i] = temp;
         }
    }

    //print deck
    public void printDeck() {
        for (int i =0; i< numOfCards; i++)
            System.out.println(DECK[i]);
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.printDeck();
        deck.shuffleDeck();
        deck.printDeck();
    }
}
