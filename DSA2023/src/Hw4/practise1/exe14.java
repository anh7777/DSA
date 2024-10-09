package Hw4.practise1;

import java.util.Scanner;
import java.util.Stack;

public class exe14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> st = new Stack<>();

        int n = sc.nextInt();

        // Đẩy các bit nhị phân vào stack
        while (n > 0) {
            st.push((char) (n % 2 + '0'));  // Chuyển số bit thành ký tự '0' hoặc '1'
            n /= 2;
        }

        // In ra các bit nhị phân
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }

        sc.close(); // Đóng Scanner sau khi sử dụng
    }
}
