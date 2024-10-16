package Hw3_22001235_NguyenNgocAnh.Exercise2;

public class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Phần tử trên cùng của stack: " + stack.top());
        System.out.println("Pop phần tử: " + stack.pop());
        System.out.println("Stack có trống không? " + stack.isEmpty());

        for (Integer i : stack) {
            System.out.println("Phần tử: " + i);
        }

        System.out.println("Kích thước stack hiện tại: " + stack.top());
    }
}
