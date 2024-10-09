package Phan5;// Hoàn thành phương thức mergeArray thực hiện ghép 2 mảng a, b đã được sắp xếp thành 1 mảng đã được sắp xếp.
import java.util.Arrays;


public class MergeArray{
    
    public int[] mergeArray(int[] a, int[] b)
    {
        int[] mergedArray = new int[a.length + b.length];
        int i = 0, j= 0, k =0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                mergedArray[k++] = a[i++];
            } else {
                mergedArray[k++] = b[j++];
            }
        }

        while (i < a.length) {
            mergedArray[k++] = a[i++];
        }

        while (j < b.length) {
            mergedArray[k++] = b[j++];
        }

        return mergedArray;
    }

    public static void main(String[] args) {
        MergeArray merger = new MergeArray();

        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        int[] merged = merger.mergeArray(a, b);
        System.out.println("Mảng đã được ghép và sắp xếp: " + Arrays.toString(merged));
    }

    
}

