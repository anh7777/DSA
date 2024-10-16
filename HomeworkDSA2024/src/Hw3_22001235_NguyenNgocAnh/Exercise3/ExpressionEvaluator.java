package Hw3_22001235_NguyenNgocAnh.Exercise3;

import java.util.Stack;

public class ExpressionEvaluator {
    public static void main(String[] args) {
        String expression1 = "(1 + ((2 + 3) * (8 * 5)))";
        System.out.println("Biểu thức 1 có hợp lệ về dấu ngoặc không? " + isValidParentheses(expression1));
        System.out.println("Kết quả biểu thức 1: " + evaluate(expression1));

        String expression2 = "(5 - (8 - 4) * (2 + 3)) + (8 / 4)";
        System.out.println("Biểu thức 2 có hợp lệ về dấu ngoặc không? " + isValidParentheses(expression2));
        System.out.println("Kết quả biểu thức 2: " + evaluate(expression2));

        String invalidExpression = "(10 + 8)/((5 - 2) * 17))";
        System.out.println("Biểu thức không hợp lệ có hợp lệ về dấu ngoặc không? " + isValidParentheses(invalidExpression));
        try {
            System.out.println("Kết quả biểu thức không hợp lệ: " + evaluate(invalidExpression));
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    public static boolean isValidParentheses(String expression) {
        Stack<Character> stack = new Stack<Character>();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static int evaluate(String expression) {
        if (!isValidParentheses(expression)) {
            throw new IllegalArgumentException("Khong hop le");
        }

        Stack<Integer> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(') {
                operators.push(c);
            } else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                if (operators.isEmpty()) {
                    throw new IllegalArgumentException("Khong hop le");
                }
                operators.pop();
            }

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();

                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    sb.append(expression.charAt(i++));
                }
                values.push(Integer.parseInt(sb.toString()));
                i--;
            } else if (c =='+' || c == '-'||c=='*'||c=='/') {
                while (!operators.isEmpty() && hasPrecedence(c, operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(c);
            }
        }
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

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
}
