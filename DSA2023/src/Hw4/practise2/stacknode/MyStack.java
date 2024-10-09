package Hw4.practise2.stacknode;

public class MyStack {
    StackNode top;

    MyStack() {
        top = null;
    }

    // Thêm phần tử vào stack
    void push(int x) {
        StackNode newNode = new StackNode(x);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    // Loại bỏ phần tử trên cùng của stack và trả về giá trị của nó
    int pop() {
        if (top == null) {
            System.out.println("Stack is empty");
            return -1; // Giả định -1 là giá trị đại diện cho stack rỗng
        } else {
            int result = top.data;
            top = top.next;
            return result;
        }
    }

    // Kiểm tra stack có rỗng không
    boolean isEmpty() {
        return top == null;
    }
}