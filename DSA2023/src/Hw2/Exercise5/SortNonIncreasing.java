package Hw2.Exercise5;

import java.util.Scanner;

public class SortNonIncreasing {

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        bubbleSort(array);

        System.out.println("Dãy số sau khi sắp xếp không tăng:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
