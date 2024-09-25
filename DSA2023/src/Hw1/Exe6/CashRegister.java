package Hw1.Exe6;

import java.util.Scanner;

public class CashRegister {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalPrice = 0;
        double itemPrice;

        System.out.println("Nhập giá của từng món hàng. Nhập số âm để kết thúc.");

        while (true) {
            System.out.print("Nhập giá món hàng: ");
            itemPrice = scanner.nextDouble();
            if (itemPrice < 0) break;
            totalPrice += itemPrice;
        }

        System.out.println("Tổng tiền: " + totalPrice);

        System.out.print("Nhập số tiền khách đưa: ");
        double amountPaid = scanner.nextDouble();

        if (amountPaid >= totalPrice) {
            double change = amountPaid - totalPrice;
            System.out.println("Tiền thừa: " + change);
        } else {
            System.out.println("Số tiền không đủ. Bạn thiếu " + (totalPrice - amountPaid));
        }
    }
}
