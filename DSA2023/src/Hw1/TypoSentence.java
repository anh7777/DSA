package Hw1;

import java.util.Random;

public class TypoSentence {
    public static void main(String[] args) {
        String sentence = "I will never spam my friends again.";
        Random rand = new Random();
        String[] sentences = new String[100];

        for (int i = 0; i < 100; i++) {
            StringBuilder typoSentence = new StringBuilder(sentence);
            for (int j = 0; j < 8; j++) {
                int idx = rand.nextInt(typoSentence.length());
                typoSentence.setCharAt(idx, (char) ('a' + rand.nextInt(26)));
            }
            sentences[i] = (i + 1) + ": " + typoSentence;
        }

        for (String s : sentences) {
            System.out.println(s);
        }
    }
}

