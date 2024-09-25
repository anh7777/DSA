package Hw1_22001235_NguyenNgocAnh.Exercise4;

import java.util.Scanner;

public class ShellSort {

    public static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void shellSort(int[] arr, int n) {
        for (int interval = n / 2; interval > 0; interval /= 2) {
            for (int i = interval; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= interval && arr[j - interval] > temp; j -= interval) {
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        shellSort(arr, n);

        printArray(arr, n);

        sc.close();
    }
}

