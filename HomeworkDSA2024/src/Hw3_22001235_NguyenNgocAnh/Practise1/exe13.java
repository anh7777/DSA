package Hw3_22001235_NguyenNgocAnh.Practise1;

import java.util.Scanner;
import java.util.Stack;

public class exe13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        String s = sc.nextLine();

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }

        sc.close();
    }
}
