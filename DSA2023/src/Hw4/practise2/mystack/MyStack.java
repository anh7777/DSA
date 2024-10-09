package Hw4.practise2.mystack;

class MyStack {
    int[] arr;
    int top;
    int capacity;

    // Constructor để khởi tạo ngăn xếp với kích thước n
    MyStack(int n) {
        capacity = n;
        arr = new int[capacity];
        top = -1;  // Ban đầu ngăn xếp trống
    }

    // Thêm phần tử vào stack
    void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
        } else {
            arr[++top] = x;
        }
    }

    // Loại bỏ phần tử trên cùng của stack và trả về giá trị của nó
    int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1; // Giả định -1 là giá trị đại diện cho stack rỗng
        } else {
            return arr[top--];
        }
    }

    // Kiểm tra stack có rỗng không
    boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra stack có đầy không
    boolean isFull() {
        return top == capacity - 1;
    }
}
