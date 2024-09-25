package Hw1_22001235_NguyenNgocAnh.Exercise6;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Nhập k (1 <= k <= " + n + "): ");
        int k = scanner.nextInt();

        Arrays.sort(array);

        if (k >= 1 && k <= n) {
            System.out.println("Số bé thứ " + k + " là: " + array[k - 1]);
        } else {
            System.out.println("Giá trị k không hợp lệ.");
        }
    }
}
