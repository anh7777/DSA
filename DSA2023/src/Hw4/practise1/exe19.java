package Hw4.practise1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exe19 {
    // Hàm kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();

        int n = sc.nextInt();  // Nhập số n

        // Đưa các số nguyên tố từ 2 đến 9 vào hàng đợi
        for (int i = 2; i <= n && i < 10; i++) {
            if (isPrime(i)) {
                q.add(i);
            }
        }

        // Tiếp tục xử lý các số trong hàng đợi
        while (!q.isEmpty()) {
            for (int i = 1; i <= 9; i++) {
                int k = q.peek() * 10 + i;
                if (k <= n && isPrime(k)) {
                    q.add(k);  // Thêm số mới vào hàng đợi nếu là số nguyên tố
                }
            }
            System.out.print(q.poll() + " ");  // In phần tử ở đầu hàng đợi và xóa nó
        }

        sc.close();  // Đóng Scanner sau khi sử dụng
    }
}
