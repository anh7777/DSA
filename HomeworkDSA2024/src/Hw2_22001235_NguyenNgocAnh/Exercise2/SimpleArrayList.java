package Hw2_22001235_NguyenNgocAnh.Exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    @SuppressWarnings("unchecked")
    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    @SuppressWarnings("unchecked")
    public SimpleArrayList(int capacity) {
        if (capacity > 0) {
            array = (T[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity phải lớn hơn 0");
        }
    }

    @Override
    public void add(T data) {
        if (n == array.length) {
            resize(array.length * 2);
        }
        array[n++] = data;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ");
        }
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Chỉ số không hợp lệ");
        }
        array[i] = data;
    }

    @Override
    public void remove(T data) {
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = index; i < n - 1; i++) {
                array[i] = array[i + 1];
            }
            array[n - 1] = null;
            n--;
        }
    }

    @Override
    public boolean isContain(T data) {
        for (int i = 0; i < n; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
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
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = 0;

            public boolean hasNext() {
                return current < n;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[current++];
            }
        };
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity]; // Tạo mảng mới với kích thước lớn hơn
        System.arraycopy(array, 0, newArray, 0, n); // Sao chép các phần tử từ mảng cũ
        array = newArray;
    }
}
