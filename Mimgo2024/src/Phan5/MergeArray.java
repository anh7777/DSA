package Phan5;// Hoàn thành phương thức mergeArray thực hiện ghép 2 mảng a, b đã được sắp xếp thành 1 mảng đã được sắp xếp.
import java.util.Arrays;

public class MergeArray {

    /**
     * Gộp hai mảng đã được sắp xếp thành một mảng sắp xếp.
     * @param arr1 mảng đã sắp xếp thứ nhất
     * @param arr2 mảng đã sắp xếp thứ hai
     * @return mảng đã sắp xếp chứa tất cả các phần tử của arr1 và arr2
     */
    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        // Gộp hai mảng
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Sao chép các phần tử còn lại từ arr1 (nếu có)
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Sao chép các phần tử còn lại từ arr2 (nếu có)
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        // Mảng ví dụ
        int[] array1 = {1, 3, 5, 7};
        int[] array2 = {2, 4, 6, 8};

        // Gộp các mảng
        int[] mergedArray = mergeArray(array1, array2);

        // In mảng đã gộp
        System.out.println("Mảng đã gộp: " + Arrays.toString(mergedArray));
    }
}
