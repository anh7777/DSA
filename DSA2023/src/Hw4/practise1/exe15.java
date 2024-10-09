package Hw4.practise1;

import java.util.Scanner;
import java.util.Stack;

public class exe15 {
    // Hàm chuyển đổi số nguyên sang chuỗi
    public static String toString(long n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.insert(0, (char) (n % 10 + '0'));
            n /= 10;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // Thêm ký tự '@' vào cuối chuỗi để đảm bảo duyệt hết các phần tử
        s = s + '@';
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() || st.peek() == s.charAt(i)) {
                st.push(s.charAt(i));
            } else {
                int count = 0;
                str.append(st.peek());
                while (!st.isEmpty()) {
                    count++;
                    st.pop();
                }
                str.append(toString(count));
                st.push(s.charAt(i));
            }
        }

        System.out.println(str);
        sc.close(); // Đóng Scanner sau khi sử dụng
    }
}
