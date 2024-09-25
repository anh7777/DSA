package Hw3.Exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n;
    private int defaultSize;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        if (capacity >0) {
            array = (T[]) new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
    }
    @Override
    public void add(T data) {
        if (n == array.length) {
            resizeArray();
        }
        array[n++] = data;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[i];
    }

    @Override
    public void set(int i, T data) {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Index out of bounds");
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
                array[i] = array[i+1];
            }
            array[n - 1] = null;
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
        return n==0;
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

    private void resizeArray() {
        T[] newArray = (T[]) new Object[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}
