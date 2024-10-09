package Hw4.Exercise4;

import java.util.Iterator;

public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int n;          // Dung lượng tối đa của hàng đợi
    private int top = 0;    // Chỉ số phần tử đầu tiên
    private int count = 0;  // Số phần tử hiện tại trong hàng đợi
    private int default_size = 100;

    // Constructor với dung lượng tùy chọn
    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    // Constructor với dung lượng mặc định
    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    // Thêm phần tử vào cuối hàng đợi
    @Override
    public void enqueue(E element) {
        if (count == n) {
            throw new IllegalStateException("Hàng đợi đầy.");
        }
        int end = (top + count) % n;
        queue[end] = element;
        count++;
    }

    // Loại bỏ và trả về phần tử đầu tiên trong hàng đợi
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Hàng đợi rỗng.");
        }
        E element = queue[top];
        queue[top] = null; // Xóa phần tử
        top = (top + 1) % n;
        count--;
        return element;
    }

    // Kiểm tra hàng đợi có rỗng không
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    // Trả về một iterator để duyệt qua các phần tử trong hàng đợi
    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator();
    }

    // Lớp Iterator để duyệt qua các phần tử trong hàng đợi
    private class ArrayQueueIterator implements Iterator<E> {
        private int current = top;
        private int num = 0;

        @Override
        public boolean hasNext() {
            return num < count;
        }

        @Override
        public E next() {
            E data = queue[(current + num) % n];
            num++;
            return data;
        }
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.dequeue()); // 2
        queue.enqueue(4);
        queue.enqueue(5);

        for (Integer item : queue) {
            System.out.println(item);
        }
    }
}
