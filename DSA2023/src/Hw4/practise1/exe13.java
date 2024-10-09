package Hw4.practise1;

import java.util.Scanner;
import java.util.Stack;

public class exe13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        String s = sc.nextLine();

        // Đẩy các ký tự vào stack
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        // Lấy các ký tự ra khỏi stack và in ra
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }

        sc.close(); // Đóng Scanner sau khi sử dụng
    }
}
