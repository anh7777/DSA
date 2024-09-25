package Hw1;

import java.util.Scanner;

public class BasicDataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số nguyên: ");
        int intValue = sc.nextInt();

        System.out.print("Nhập số thực: ");
        double doubleValue = sc.nextDouble();

        System.out.print("Nhập ký tự: ");
        char charValue = sc.next().charAt(0);

        System.out.print("Nhập giá trị boolean: ");
        boolean booleanValue = sc.nextBoolean();

        System.out.println("Giá trị bạn nhập:");
        System.out.println("Số nguyên: " + intValue);
        System.out.println("Số thực: " + doubleValue);
        System.out.println("Ký tự: " + charValue);
        System.out.println("Boolean: " + booleanValue);
    }
}
