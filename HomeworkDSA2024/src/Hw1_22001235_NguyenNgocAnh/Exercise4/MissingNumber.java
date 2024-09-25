package Hw1_22001235_NguyenNgocAnh.Exercise4;

import java.util.Scanner;

public class MissingNumber {

    public static void quickSort(int[] arr, int l, int r) {
        int p = arr[(l + r) / 2];
        int i = l, j = r;

        while (i <= j) {
            while (arr[i] < p) {
                i++;
            }
            while (arr[j] > p) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (l < j) {
            quickSort(arr, l, j);
        }
        if (i < r) {
            quickSort(arr, i, r);
        }
    }

    public static int solve(int[] arr, int n) {
        quickSort(arr, 0, n - 1);
        if (arr[0] > 0) return 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                return arr[i - 1] + 1;
            }
        }
        return arr[n - 1] + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr, n));

        sc.close();
    }
}

