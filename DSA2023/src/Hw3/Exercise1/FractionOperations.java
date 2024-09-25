package Hw3.Exercise1;

import java.util.Scanner;

public class FractionOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số lượng phân số: ");
        int n = scanner.nextInt();

        Fraction[] fractions = new Fraction[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập tử và mẫu cho phân số thứ " + (i + 1) + ": ");
            float numerator = scanner.nextFloat();
            float denominator = scanner.nextFloat();
            fractions[i] = new Fraction(numerator, denominator);
        }

        // In phân số ở vị trí v
        System.out.println("Nhập vị trí v: ");
        int v = scanner.nextInt();
        System.out.println("Phân số tại vị trí " + v + ": " + fractions[v - 1]);

        // Tính tổng của n phân số
        Fraction sum = fractions[0];
        for (int i = 1; i < n; i++) {
            sum = sum.add(fractions[i]);
        }
        System.out.println("Tổng của dãy phân số là: " + sum);

        // Thực hiện trừ, nhân, chia tương tự
        Fraction sub = fractions[0];
        for (int i = 1; i < n; i++) {
            sub = sub.minus(fractions[i]);
        }
        System.out.println("Hiệu của dãy phân số là: " + sub);

        Fraction product = fractions[0];
        for (int i = 1; i < n; i++) {
            product = product.multi(fractions[i]);
        }
        System.out.println("Tích của dãy phân số là: " + product);

        Fraction div = fractions[0];
        for (int i = 1; i < n; i++) {
            div = div.divi(fractions[i]);
        }
        System.out.println("Thương của dãy phân số là: " + div);

        // Sử dụng phương thức đã đề xuất: so sánh 2 phânsố
        if (fractions[0].isGreaterThan(fractions[1])) {
            System.out.println("Phân số đầu tiên lớn hơn phân số thứ hai.");
        } else {
            System.out.println("Phân số đầu tiên nhỏ hơn hoặc bằng phân số thứ hai.");
        }

        scanner.close();
    }
}

