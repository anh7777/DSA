package Hw1;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseLines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();

        System.out.println("Nhập các dòng văn bản (gõ 'exit' để dừng):");
        String line;
        while (!(line = sc.nextLine()).equals("exit")) {
            lines.add(line);
        }

        System.out.println("\nCác dòng theo thứ tự ngược:");
        for (int i = lines.size() - 1; i >= 0; i--) {
            System.out.println(lines.get(i));
        }
    }
}
