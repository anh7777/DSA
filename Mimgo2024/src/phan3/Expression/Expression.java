package phan3.Expression;

import java.util.Stack;

public class Expression{
    
    public boolean isValidExpr(String expr)
    {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

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
    
    public static void main(String[] args)
    {
        
        Expression expr = new Expression();
        String f = "a+b-c(3+a)";
        System.out.println(expr.isValidExpr(f));
        
    }
    
    
}