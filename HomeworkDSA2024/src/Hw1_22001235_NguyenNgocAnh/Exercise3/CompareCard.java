package Hw1_22001235_NguyenNgocAnh.Exercise3;

import java.util.Comparator;

public class CompareCard implements Comparator<Card> {
    @Override
    public int compare(Card c1, Card c2) {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        int rank1 = getRankIndex(c1.getRank(), ranks);
        int rank2 = getRankIndex(c2.getRank(), ranks);

        if (rank1 != rank2) {
            return rank1 - rank2;
        }
        return c1.getSuit().compareTo(c2.getSuit());
    }
    private int getRankIndex(String rank, String[] ranks) {
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i].equals(rank)) {
                return i;
            }
        }
        return -1;
    }
}
