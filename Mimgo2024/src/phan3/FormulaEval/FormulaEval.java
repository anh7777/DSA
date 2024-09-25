package phan3.FormulaEval;

import java.util.Stack;

public class FormulaEval {

	public double eval(String formula) {
		String[] tokens = formula.split(" ");
		Stack<Integer> operandStack = new Stack<>();
		Stack<String> operatorStack = new Stack<>();

		for (String token : tokens) {
			if (token.equals("(")) {
				continue;
			} else if (token.equals(")")) {
				int operand2 = operandStack.pop();
				int operand1 = operandStack.pop();
				String operator = operatorStack.pop();

				int result = evaluate(operand1, operand2, operator);
				operandStack.push(result);
			} else if (isOperator(token)) {
				operatorStack.push(token);
			} else {
				operandStack.push(Integer.parseInt(token));
			}
		}

		return operandStack.pop();
	}

	private boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

	private int evaluate(int operand1, int operand2, String operator) {
		return switch (operator) {
			case "+" -> operand1 + operand2;
			case "-" -> operand1 - operand2;
			case "*" -> operand1 * operand2;
			case "/" -> {
				if (operand2 == 0) throw new ArithmeticException("Division by zero");
				yield operand1 / operand2;
			}
			default -> throw new IllegalArgumentException("Invalid operator");
		};
	}
}
