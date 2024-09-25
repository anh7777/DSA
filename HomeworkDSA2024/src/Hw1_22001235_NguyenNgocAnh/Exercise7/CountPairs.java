package Hw1_22001235_NguyenNgocAnh.Exercise7;

import java.util.Arrays;
import java.util.Scanner;

public class CountPairs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Nhập giá trị x: ");
        int x = scanner.nextInt();

        // Cách 1:
        int count1 = countPairsBruteForce(array, n, x);
        System.out.println("Số cặp (ai + aj = x) bằng cách duyệt: " + count1);

        // Cách 2:
        int count2 = countPairsUsingSorting(array, n, x);
        System.out.println("Số cặp (ai + aj = x) bằng cách sắp xếp và tìm kiếm nhị phân: " + count2);
    }

    // Cách 1:
    public static int countPairsBruteForce(int[] array, int n, int x) {
        int count = 0;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (array[i] + array[j] == x) {
                    count++;
                }
            }
        }
        return count;
    }

    // Cách 2:
    public static int countPairsUsingSorting(int[] array, int n, int x) {
        Arrays.sort(array);
        int count = 0;

        for (int j = 1; j < n; j++) {
            int target = x - array[j];
            int leftIndex = binarySearch(array, target, 0, j - 1, true);
            int rightIndex = binarySearch(array, target, 0, j - 1, false);
            if (leftIndex != -1 && rightIndex != -1) {
                count += (rightIndex - leftIndex + 1);
            }
        }
        return count;
    }

    // Tìm kiếm nhị phân
    public static int binarySearch(int[] array, int target, int left, int right, boolean findLeft) {
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                result = mid;
                if (findLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
