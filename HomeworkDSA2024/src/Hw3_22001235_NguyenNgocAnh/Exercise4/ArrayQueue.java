package Hw3_22001235_NguyenNgocAnh.Exercise4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n;
    private int top;
    private int count;
    private static final int DEFAULT_SIZE = 100;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        n = DEFAULT_SIZE;
        queue = (E[]) new Object[DEFAULT_SIZE];
        top = 0;
        count = 0;
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
        top = 0;
        count = 0;
    }

    @Override
    public void enqueue(E element) {
        if (count == n) {
            resize(2 * n); // Mở rộng kích thước mảng
        }
        int end = (top + count) % n;
        queue[end] = element;
        count++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        E element = queue[top];
        queue[top] = null;
        top = (top + 1) % n;
        count--;
        if (count > 0 && count == n / 4) {
            resize(n / 2);
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public E peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[top];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        E[] newQueue = (E[]) new Object[newSize];
        for (int i = 0; i < count; i++) {
            newQueue[i] = queue[(top + i) % n];
        }
        queue = newQueue;
        top = 0;
        n = newSize;
    }

    private class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }
}
