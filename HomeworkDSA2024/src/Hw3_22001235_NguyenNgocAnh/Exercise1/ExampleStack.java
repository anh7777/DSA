package Hw3_22001235_NguyenNgocAnh.Exercise1;
import java.util.Stack;

public class ExampleStack {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String hoten = "nguyenngocanh";

        stack = getStack(hoten, stack);
        System.out.println("Ket qua: " + stack.toString());
    }

    public static Stack<Character> getStack(String hoten, Stack<Character> s) {
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }
            if (i % 3 == 0) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            }
        }
        return s;
    }
}
