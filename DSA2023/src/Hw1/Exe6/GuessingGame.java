package Hw1.Exe6;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess = 0;

        System.out.println("Tôi đang nghĩ đến một số từ 1 đến 100. Bạn đoán thử nào!");

        while (guess != numberToGuess) {
            System.out.print("Nhập số bạn đoán: ");
            guess = scanner.nextInt();

            if (guess < numberToGuess) {
                System.out.println("Số của tôi lớn hơn!");
            } else if (guess > numberToGuess) {
                System.out.println("Số của tôi nhỏ hơn!");
            } else {
                System.out.println("Chúc mừng, bạn đã đoán đúng!");
            }
        }
    }
}
