package Hw4.practise2.stacknode;

public class StackNodeTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());  // Kết quả: 30
        System.out.println(stack.pop());  // Kết quả: 20
        System.out.println(stack.pop());  // Kết quả: 10
    }
}
