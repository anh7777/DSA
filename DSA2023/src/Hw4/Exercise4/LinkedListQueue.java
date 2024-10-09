package Hw4.Exercise4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListQueue<E> implements QueueInterface<E> {
    private Node<E> front;  // Điểm đầu của hàng đợi
    private Node<E> rear;   // Điểm cuối của hàng đợi
    private int count;      // Số phần tử trong hàng đợi

    // Lớp Node bên trong
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    // Thêm phần tử vào cuối hàng đợi
    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
        count++;
    }

    // Loại bỏ và trả về phần tử đầu tiên trong hàng đợi
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Hàng đợi rỗng.");
        }
        E element = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
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
        return new LinkedQueueIterator();
    }

    // Lớp Iterator cho LinkedQueue
    private class LinkedQueueIterator implements Iterator<E> {
        private Node<E> current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
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

