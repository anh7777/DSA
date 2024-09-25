package Hw2.Exercise4;

import java.util.Scanner;

public class BubbleSort {

    public static void printArray(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void bubbleSort(int[] a, int n) {
        for (int i = n - 1; i >= 1; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        bubbleSort(a, n);

        printArray(a, n);

        sc.close();
    }
}
