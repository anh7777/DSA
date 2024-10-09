package Hw5.Exercise1;
public class ArrayBinaryTree<E> implements BinaryTreeInterface<Integer> {
    private E[] array;
    private int n = 0;
    private int defaultsize = 100;

    // Constructor khởi tạo cây nhị phân với kích thước mặc định
    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultsize];
    }

    // Set phần tử cho root (chỉ khi cây rỗng)
    public void setRoot(E element) {
        array[1] = element; // Phần tử gốc tại vị trí 1
        n++;
    }

    // Set phần tử cho con trái của node tại vị trí p
    public void setLeft(int p, E element) {
        int leftIndex = 2 * p;
        if (leftIndex < array.length) {
            array[leftIndex] = element;
            n++;
        }
    }

    // Set phần tử cho con phải của node tại vị trí p
    public void setRight(int p, E element) {
        int rightIndex = 2 * p + 1;
        if (rightIndex < array.length) {
            array[rightIndex] = element;
            n++;
        }
    }

    @Override
    public Integer root() {
        return 1; // Vị trí root là 1
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int numChildren(Integer p) {
        int count = 0;
        if (2 * p < array.length && array[2 * p] != null) count++;
        if (2 * p + 1 < array.length && array[2 * p + 1] != null) count++;
        return count;
    }

    @Override
    public Integer parent(Integer p) {
        if (p == 1) return null; // Gốc không có cha
        return p / 2;
    }

    @Override
    public Integer left(Integer p) {
        int leftIndex = 2 * p;
        return (leftIndex < array.length && array[leftIndex] != null) ? leftIndex : null;
    }

    @Override
    public Integer right(Integer p) {
        int rightIndex = 2 * p + 1;
        return (rightIndex < array.length && array[rightIndex] != null) ? rightIndex : null;
    }

    @Override
    public Integer sibling(Integer p) {
        if (p == 1) return null; // Gốc không có anh/chị em
        if (p % 2 == 0) {
            return (2 * p + 1 < array.length && array[2 * p + 1] != null) ? p + 1 : null;
        } else {
            return (2 * p - 1 > 0 && array[2 * p - 1] != null) ? p - 1 : null;
        }
    }
}
