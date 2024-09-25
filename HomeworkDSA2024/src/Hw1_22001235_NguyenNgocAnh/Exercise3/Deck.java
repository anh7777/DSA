package Hw1_22001235_NguyenNgocAnh.Exercise3;

public class Deck {
    private Card[] cards = new Card[52];
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Deck() {
        int index = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                cards[index] = new Card(suit, rank);
            }
        }
    }

    public Card[] getCards() {
        return cards;
    }
}
