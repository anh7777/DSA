package Hw2.Exercise1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortEvaluation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước của dãy số: ");
        int n = scanner.nextInt();

        Integer[] array = new Integer[n];

        System.out.println("Nhập dãy số:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Nhập N để sinh N số ngẫu nhiên: ");
        int N = scanner.nextInt();
        Integer[] randomArray = generateRandomArray(N, 105);

        System.out.println("Dãy số ngẫu nhiên sinh ra:");
        System.out.println(Arrays.toString(randomArray));

        runSortingAlgorithms(array);
        runSortingAlgorithms(randomArray);
    }

    // Sinh N số ngẫu nhiên trong khoảng [1, bound]
    public static Integer[] generateRandomArray(int n, int bound) {
        Random rand = new Random();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(bound) + 1;
        }
        return array;
    }

    // Triển khai các thuật toán sắp xếp
    public static void runSortingAlgorithms(Integer[] array) {
        bubbleSort(array.clone());
        selectionSort(array.clone());
        insertionSort(array.clone());
        mergeSort(array.clone(), 0, array.length - 1);
        quickSort(array.clone(), 0, array.length - 1);
    }

    // Sắp xếp nổi bọt
    public static void bubbleSort(Integer[] array) {
        System.out.println("Bubble Sort:");
        int comparisons = 0, swaps = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swaps++;
                }
            }
            System.out.println("Trạng thái sau vòng lặp " + (i + 1) + ": " + Arrays.toString(array));
        }
        System.out.println("Số lần so sánh: " + comparisons + ", số lần đổi chỗ: " + swaps);
    }

    // Sắp xếp chọn
    public static void selectionSort(Integer[] array) {
        System.out.println("Selection Sort:");
        int comparisons = 0, swaps = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                comparisons++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                swaps++;
            }
            System.out.println("Trạng thái sau vòng lặp " + (i + 1) + ": " + Arrays.toString(array));
        }
        System.out.println("Số lần so sánh: " + comparisons + ", số lần đổi chỗ: " + swaps);
    }

    // Sắp xếp chèn
    public static void insertionSort(Integer[] array) {
        System.out.println("Insertion Sort:");
        int comparisons = 0, swaps = 0;
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                comparisons++;
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
            swaps++;
            System.out.println("Trạng thái sau vòng lặp " + i + ": " + Arrays.toString(array));
        }
        System.out.println("Số lần so sánh: " + comparisons + ", số lần đổi chỗ: " + swaps);
    }

    // Sắp xếp trộn
    public static void mergeSort(Integer[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(Integer[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        Integer[] L = new Integer[n1];
        Integer[] R = new Integer[n2];
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
        System.out.println("Trạng thái sau vòng lặp merge: " + Arrays.toString(array));
    }

    // Sắp xếp nhanh
    public static void quickSort(Integer[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(Integer[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        System.out.println("Trạng thái sau partition: " + Arrays.toString(array));
        return i + 1;
    }
}
