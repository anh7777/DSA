package Hw4.practise1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exe17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();  // Sử dụng LinkedList để làm hàng đợi

        int n = sc.nextInt();  // Số phần tử trong hàng đợi
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            q.add(temp);  // Thêm phần tử vào hàng đợi
        }

        int k = sc.nextInt();  // Số lần xoay vòng
        for (int i = 0; i < k; i++) {
            int x = q.poll();  // Lấy phần tử ở đầu hàng đợi và xóa nó
            q.add(x);          // Đưa phần tử vừa lấy ra vào cuối hàng đợi
        }

        // In các phần tử còn lại trong hàng đợi
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }

        sc.close();  // Đóng Scanner sau khi sử dụng
    }
}
