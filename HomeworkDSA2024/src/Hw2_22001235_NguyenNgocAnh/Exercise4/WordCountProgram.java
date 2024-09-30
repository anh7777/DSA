package Hw2_22001235_NguyenNgocAnh.Exercise4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Hw2_22001235_NguyenNgocAnh.Exercise2.SimpleArrayList;

public class WordCountProgram {
    public static void main(String[] args) {
        SimpleArrayList<WordCount> wordList = new SimpleArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên file (hoặc nhập văn bản):");
        String input = scanner.nextLine();

        if (!input.endsWith(".txt")) {
            String[] words = input.split("\\s+");
            countWords(words, wordList);
        } else {
            try (BufferedReader br = new BufferedReader(new FileReader(input))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] words = line.split("\\s+");
                    countWords(words, wordList);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            WordCount wc = wordList.get(i);
            System.out.println(wc.getWord() + ": " + wc.getCount());
        }
    }

    private static void countWords(String[] words, SimpleArrayList<WordCount> wordList) {
        for (String word : words) {
            boolean found = false;
            for (int i = 0; i < wordList.size(); i++) {
                WordCount wc = wordList.get(i);
                if (wc.getWord().equalsIgnoreCase(word)) {
                    wc.incrementCount();
                    found = true;
                    break;
                }
            }
            if (!found) {
                wordList.add(new WordCount(word));
            }
        }
    }
}
