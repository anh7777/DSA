package Hw4.Exercise3;

import java.util.Stack;

public class ExpressionEvaluator {

    // Phần a: Kiểm tra tính hợp lệ của dấu ngoặc
    public static boolean isValidParentheses(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Dấu ngoặc đóng không có dấu ngoặc mở tương ứng
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // Kiểm tra nếu còn dấu ngoặc mở chưa được đóng
    }

    // Phần b: Tính giá trị của biểu thức nếu hợp lệ
    public static int evaluateExpression(String expression) {
        if (!isValidParentheses(expression)) {
            throw new IllegalArgumentException("Biểu thức không hợp lệ về dấu ngoặc.");
        }

        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Nếu là dấu cách, bỏ qua
            if (ch == ' ') {
                continue;
            }

            // Nếu là số, đọc tất cả các chữ số liên tiếp và đưa vào stack
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    sb.append(expression.charAt(i++));
                }
                values.push(Integer.parseInt(sb.toString()));
                i--; // Để không bỏ qua ký tự sau khi số
            }

            // Nếu là dấu ngoặc mở, đưa vào stack
            else if (ch == '(') {
                operators.push(ch);
            }

            // Nếu là dấu ngoặc đóng, tính tất cả các biểu thức trong dấu ngoặc
            else if (ch == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Bỏ dấu ngoặc mở
            }

            // Nếu là toán tử, tính toán các toán tử ưu tiên cao trước đó
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && hasPrecedence(ch, operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(ch);
            }
        }

        // Tính toán các toán tử còn lại trong stack
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        // Kết quả cuối cùng
        return values.pop();
    }

    // Phương thức kiểm tra ưu tiên toán tử
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    // Phương thức áp dụng toán tử
    public static int applyOperator(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Không thể chia cho 0");
                }
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        // Kiểm tra tính hợp lệ của dấu ngoặc
        String expression1 = "(1 + ((2 + 3) * (8 * 5)))";
        System.out.println("Biểu thức 1 có hợp lệ về dấu ngoặc không? " + isValidParentheses(expression1));
        System.out.println("Kết quả biểu thức 1: " + evaluateExpression(expression1));

        String expression2 = "(5 - (8 - 4) * (2 + 3)) + (8 / 4)";
        System.out.println("Biểu thức 2 có hợp lệ về dấu ngoặc không? " + isValidParentheses(expression2));
        System.out.println("Kết quả biểu thức 2: " + evaluateExpression(expression2));

        String invalidExpression = "(10 + 8)/((5 - 2) * 17))";
        System.out.println("Biểu thức không hợp lệ có hợp lệ về dấu ngoặc không? " + isValidParentheses(invalidExpression));
        try {
            System.out.println("Kết quả biểu thức không hợp lệ: " + evaluateExpression(invalidExpression));
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }
}
