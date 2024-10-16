package Phan6.RLE;

import java.util.ArrayList;

public class RLE {

    /**
     * Computes the length of the compression array.
     * @param t a binary array
     * @return an integer.
     */
    public static int length(int[] t) {
        if (t.length == 0) return 0;

        int compressedLength = 0;
        int currentValue = t[0];
        int count = 1;

        for (int i = 1; i < t.length; i++) {
            if (t[i] == currentValue) {
                count++;
            } else {
                compressedLength += 2; // Một giá trị và một đếm số
                currentValue = t[i];
                count = 1;
            }
        }
        compressedLength += 2; // Tính cho nhóm cuối cùng
        return compressedLength;
    }

    /**
     * Compresses an array in RLE format and return the result.
     * @param t
     * @return compressed array.
     */
    public static int[] compress(int[] t) {
        // TODO: Your code here
        if (t.length == 0) return new int[0];

        ArrayList<Integer> compressed = new ArrayList<>();
        int currentValue = t[0];
        int count = 1;

        for (int i = 1; i < t.length; i++) {
            if (t[i] == currentValue) {
                count++;
            } else {
                compressed.add(currentValue);
                compressed.add(count);
                currentValue = t[i];
                count = 1;
            }
        }
        compressed.add(currentValue); // Thêm nhóm cuối
        compressed.add(count);

        // Chuyển ArrayList thành mảng int[]
        return compressed.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Computes the length of the decompressed array.
     * @param t
     * @return an integer.
     */
    public static int lengthInverse(int[] t) {
        // TODO: Your code here
        int decompressedLength = 0;
        for (int i = 1; i < t.length; i += 2) {
            decompressedLength += t[i]; // t[i] là số lần lặp lại
        }
        return decompressedLength;
    }

    /**
     * Decompresses the array.
     * @param t
     * @return an array
     */
    public static int[] decompress(int[] t) {
        if (t.length == 0) return new int[0];

        ArrayList<Integer> decompressed = new ArrayList<>();

        for (int i = 0; i < t.length; i += 2) {
            int value = t[i];
            int count = t[i + 1];
            for (int j = 0; j < count; j++) {
                decompressed.add(value);
            }
        }

        // Chuyển ArrayList thành mảng int[]
        return decompressed.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        // Kiểm tra ví dụ
        int[] binaryArray = {1, 1, 1, 0, 0, 1, 1, 0};
        int[] compressed = RLE.compress(binaryArray);
        System.out.println("Compressed Length: " + RLE.length(binaryArray));
        System.out.println("Compressed Array: ");
        for (int c : compressed) {
            System.out.print(c + " ");
        }
        System.out.println("\nDecompressed Length: " + RLE.lengthInverse(compressed));
        int[] decompressed = RLE.decompress(compressed);
        System.out.println("Decompressed Array: ");
        for (int d : decompressed) {
            System.out.print(d + " ");
        }
    }
}
