package Phan4;

import java.util.Arrays;

public class Insert {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int element = 6;
        int[] newArr = insertSorted(arr, element);
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] insertSorted(int[] arr, int element) {
        int[] newArr = new int[arr.length + 1];
        int i = 0;

        while (i < arr.length && arr[i] < element) {
            newArr[i] = arr[i];
            i++;
        }

        newArr[i] = element;
        if (i < arr.length) {
            System.arraycopy(arr, i, newArr, i + 1, arr.length - i);
        }

        return newArr;
    }
}
