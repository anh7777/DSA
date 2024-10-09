package Hw4.practise5;

import java.util.Stack;

public class Main {
    // Hàm để tính toán biểu thức hậu tố
    public static int evaluatePostfix(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Nếu token là một số, thêm vào stack
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                // Nếu token là một toán tử
                int operand2 = stack.pop(); // Lấy toán hạng thứ hai
                int operand1 = stack.pop(); // Lấy toán hạng thứ nhất

                // Thực hiện phép toán
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }
        return stack.pop(); // Kết quả cuối cùng
    }

    // Hàm kiểm tra xem một chuỗi có phải là số hay không
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Ví dụ: biểu thức hậu tố
        String[] tokens = {"2", "1", "+", "3", "*"}; // Tương đương với (2 + 1) * 3
        int result = evaluatePostfix(tokens);
        System.out.println("Kết quả: " + result); // Kết quả: 9
    }
}
