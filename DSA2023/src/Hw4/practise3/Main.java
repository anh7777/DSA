package Hw4.practise3;

import java.util.Stack;

public class Main {

    // Hàm xóa phần tử giữa của stack
    public static void deleteMiddle(Stack<Integer> stack, int n, int curr) {
        // Trường hợp cơ sở: nếu stack rỗng hoặc đã đến phần tử giữa
        if (stack.isEmpty() || curr == n / 2) {
            stack.pop();  // Xóa phần tử giữa
            return;
        }

        // Lấy phần tử trên cùng ra
        int temp = stack.pop();

        // Đệ quy gọi hàm để tiếp tục xóa phần tử giữa
        deleteMiddle(stack, n, curr + 1);

        // Sau khi xóa phần tử giữa, đẩy lại các phần tử vào stack
        stack.push(temp);
    }

    // Hàm chính để gọi
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Thêm các phần tử vào stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int n = stack.size();  // Kích thước stack ban đầu

        // Gọi hàm xóa phần tử giữa
        deleteMiddle(stack, n, 0);

        // In lại stack sau khi đã xóa phần tử giữa
        System.out.println("Stack sau khi xóa phần tử giữa:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
