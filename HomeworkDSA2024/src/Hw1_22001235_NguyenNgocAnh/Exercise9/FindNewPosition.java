package Hw1_22001235_NguyenNgocAnh.Exercise9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FindNewPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Nhập chỉ số i: ");
        int i = scanner.nextInt();

        int newPosition = findNewPosition(array, i);

        System.out.println("Vị trí mới của a[" + i + "] là: " + newPosition);
    }

    public static int findNewPosition(int[] array, int index) {
        int n = array.length;
        Record[] records = new Record[n];

        for (int i = 0; i < n; i++) {
            records[i] = new Record(array[i], i);
        }

        Arrays.sort(records, Comparator.comparingInt(r -> r.value));

        for (int newIndex = 0; newIndex < n; newIndex++) {
            if (records[newIndex].index == index) {
                return newIndex;
            }
        }

        return -1;
    }
}
