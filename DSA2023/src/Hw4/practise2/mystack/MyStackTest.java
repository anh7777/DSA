package Hw4.practise2.mystack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack(5);  // Tạo stack với kích thước 5
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());  // Kết quả: 30
        System.out.println(stack.pop());  // Kết quả: 20
        System.out.println(stack.pop());  // Kết quả: 10
    }
}
