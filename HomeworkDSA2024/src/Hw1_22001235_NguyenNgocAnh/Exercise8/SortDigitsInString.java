package Hw1_22001235_NguyenNgocAnh.Exercise8;

import java.util.Scanner;

public class SortDigitsInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập xâu ký tự chứa các chữ số: ");
        String input = scanner.nextLine();

        String sortedString = sortDigits(input);

        System.out.println("Xâu sau khi sắp xếp: " + sortedString);
    }

    public static String sortDigits(String input) {

        int[] count = new int[10];

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                count[c - '0']++;
            }
        }

        StringBuilder sortedString = new StringBuilder();

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sortedString.append(i);
            }
        }

        return sortedString.toString();
    }
}
