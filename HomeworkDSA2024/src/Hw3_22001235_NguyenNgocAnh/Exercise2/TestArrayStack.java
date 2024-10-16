package Hw3_22001235_NguyenNgocAnh.Exercise2;

public class TestArrayStack {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Phần tử trên cùng của stack: " + stack.top());

        for (Integer i : stack) {
            System.out.println("Phần tử: " + i);
        }

        System.out.println("Pop phần tử: " + stack.pop());
        System.out.println("Phần tử trên cùng hiện tại: " + stack.top());
    }
}
