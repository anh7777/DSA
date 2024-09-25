package phan3.FormulaEval;


public class FormulaEvalTest {
    public static void main(String[] args) {
        FormulaEval eval = new FormulaEval();

        // Kiểm tra với các biểu thức khác nhau
        System.out.println(eval.eval("( ( 50 - ( ( 8 - 4 ) * ( 2 + 3 ) ) ) + ( 3 * 4 ) )"));
        System.out.println(eval.eval("( ( 3 + 5 ) * 2 )"));
        System.out.println(eval.eval("( ( 10 + 2 ) / ( 4 - 2 ) )"));
        System.out.println(eval.eval("( ( 7 - 2 ) + ( ( 1 + 1 ) * ( 3 + 2 ) ) )"));
        System.out.println(eval.eval("( 5 + ( ( 10 - 2 ) * 3 ) )"));
    }
}

