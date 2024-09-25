package Hw1;

import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        char operator = ' ';

        System.out.println("Máy tính đơn giản:");
        while (true) {
            System.out.print("Nhập một số: ");
            double num = sc.nextDouble();

            if (operator != ' ') {
                if (operator == '+') result += num;
                else if (operator == '-') result -= num;
                else if (operator == '*') result *= num;
                else if (operator == '/') result /= num;
            } else {
                result = num;
            }

            System.out.print("Nhập toán tử (+, -, *, /) hoặc '=' để hiển thị kết quả: ");
            operator = sc.next().charAt(0);

            if (operator == '=') {
                System.out.println("Kết quả: " + result);
                break;
            }
        }
    }
}
