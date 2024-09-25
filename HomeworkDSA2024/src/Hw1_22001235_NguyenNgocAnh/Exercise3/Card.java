package Hw1_22001235_NguyenNgocAnh.Exercise3;

import java.util.Arrays;
import java.util.Comparator;

public class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card other) {
        return this.rank.compareTo(other.rank);
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    public static void main(String[] args) {
        Card[] cards = {
                new Card("3", "Hearts"),
                new Card("A", "Spades"),
                new Card("10", "Diamonds"),
                new Card("K", "Clubs"),
                new Card("7", "Hearts")
        };

        Arrays.sort(cards);
        System.out.println("Sắp xếp theo rank:");
        for (Card card : cards) {
            System.out.println(card);
        }

        Comparator<Card> suitComparator = Comparator.comparing(Card::getSuit);
        Arrays.sort(cards, suitComparator);
        System.out.println("Sắp xếp theo suit:");
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
