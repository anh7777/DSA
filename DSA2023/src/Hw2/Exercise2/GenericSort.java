package Hw2.Exercise2;

import java.util.Arrays;

public class GenericSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void runSortingAlgorithms(T[] array) {
        bubbleSort(array.clone());
        selectionSort(array.clone());
        insertionSort(array.clone());
        mergeSort(array.clone(), 0, array.length - 1);
        quickSort(array.clone(), 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort: " + Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println("Selection Sort: " + Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        System.out.println("Insertion Sort: " + Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        T[] L = (T[]) new Comparable[n1];
        T[] R = (T[]) new Comparable[n2];
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i].compareTo(R[j]) <= 0) {
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
        System.out.println("Merge Sort: " + Arrays.toString(array));
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
