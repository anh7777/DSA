package Hw4.practise4;

import java.util.Stack;

public class Main {
    // Hàm kiểm tra tính hợp lệ của xâu ngoặc
    public static boolean isValid(String s) {
        // Tạo stack để lưu trữ các ngoặc mở
        Stack<Character> stack = new Stack<>();

        // Duyệt qua từng ký tự trong xâu
        for (char c : s.toCharArray()) {
            // Nếu là ngoặc mở, thêm vào stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Nếu là ngoặc đóng, kiểm tra
            else if (c == ')' || c == '}' || c == ']') {
                // Kiểm tra nếu stack rỗng hoặc không tương ứng
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false; // Không hợp lệ
                }
            }
        }

        // Nếu stack còn phần tử, có nghĩa là còn ngoặc mở
        return stack.isEmpty();
    }

    // Hàm kiểm tra cặp ngoặc
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String input = "{[()]}"; // Ví dụ xâu ngoặc
        if (isValid(input)) {
            System.out.println("Xâu ngoặc hợp lệ.");
        } else {
            System.out.println("Xâu ngoặc không hợp lệ.");
        }
    }
}
