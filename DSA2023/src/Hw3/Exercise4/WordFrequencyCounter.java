package Hw3.Exercise4;

import Hw3.Exercise2.SimpleArrayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        SimpleArrayList<WordCount> wordList = new SimpleArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập văn bản (hoặc đường dẫn file): ");
        String input = scanner.nextLine();

        if (input.endsWith(".txt")) {
            try {
                File file = new File(input);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNext()) {
                    String word = fileScanner.next().toLowerCase();
                    processWord(word, wordList);
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Không tìm thấy file.");
            }
        } else {
            String[] words = input.split("\\s+");
            for (String word : words) {
                processWord(word.toLowerCase(), wordList);
            }
        }

        for (int i = 0; i < wordList.size(); i++) {
            WordCount wc = wordList.get(i);
            System.out.println(wc.getWord() + ": " + wc.getCount());
        }
    }

    // Phương thức xử lý mỗi từ
    private static void processWord(String word, SimpleArrayList<WordCount> wordList) {
        WordCount newWordCount = new WordCount(word);
        for (int i = 0; i < wordList.size(); i++) {
            WordCount wc = wordList.get(i);
            if (wc.equals(newWordCount)) {
                wc.incrementCount();
                return;
            }
        }
        wordList.add(newWordCount);
    }
}
