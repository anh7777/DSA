package Hw3_22001235_NguyenNgocAnh.Practise1;

import java.util.Scanner;
import java.util.Stack;

public class exe14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        int n = sc.nextInt();

        while (n > 0) {
            st.push((char) (n % 2 + '0'));
            n /= 2;
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }

        sc.close();
    }
}
