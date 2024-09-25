package Hw1;

import java.util.HashSet;
import java.util.Random;

public class BirthdayParadox {
    public static boolean hasDuplicate(int[] birthdays) {
        HashSet<Integer> set = new HashSet<>();
        for (int day : birthdays) {
            if (!set.add(day)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int trials = 10000;

        for (int n = 5; n <= 100; n += 5) {
            int duplicates = 0;
            for (int t = 0; t < trials; t++) {
                int[] birthdays = new int[n];
                for (int i = 0; i < n; i++) {
                    birthdays[i] = rand.nextInt(365) + 1; // Sinh nhật ngẫu nhiên từ 1 đến 365
                }
                if (hasDuplicate(birthdays)) duplicates++;
            }
            double probability = (double) duplicates / trials * 100;
            System.out.printf("Với %d người, xác suất có cùng sinh nhật: %.2f%%\n", n, probability);
        }
    }
}
