package Hw2.Exercise4;

import java.util.Scanner;

public class SelectionSort {

    public static void printArray(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void selectionSort(int[] a, int n) {
        int indexMin;
        for (int i = 0; i < n - 1; i++) {
            indexMin = i;

            for (int j = i + 1; j < n; j++) {
                if (a[indexMin] > a[j]) {
                    indexMin = j;
                }
            }

            if (i != indexMin) {
                int temp = a[i];
                a[i] = a[indexMin];
                a[indexMin] = temp;
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

        selectionSort(a, n);

        printArray(a, n);

        sc.close();
    }
}
