package Hw4.Exercise5;

import java.util.Iterator;

public class LinkedListQueue<E> implements QueueInterface<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size = 0;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        E data = front.data;
        front = front.next;
        if (front == null) {
            rear = null; // Hàng đợi rỗng
        }
        return data;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListQueueIterator();
    }

    class LinkedListQueueIterator implements Iterator<E> {
        private Node<E> current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}