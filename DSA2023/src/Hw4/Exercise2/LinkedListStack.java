package Hw4.Exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListStack<E> implements StackInterface<E> {

    private class Node {
        E element;
        Node next;

        Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node stack = null;  // Biến đại diện cho đỉnh của stack
    private int size = 0;       // Biến đếm số lượng phần tử trong stack

    @Override
    public void push(E element) {
        // Thêm phần tử vào đầu danh sách liên kết (đỉnh của stack)
        stack = new Node(element, stack);
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        // Lấy phần tử ở đỉnh stack
        E element = stack.element;
        // Di chuyển đỉnh stack đến phần tử tiếp theo
        stack = stack.next;
        size--;
        return element;
    }

    @Override
    public boolean isEmpty() {
        // Kiểm tra xem stack có trống không
        return stack == null;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        // Lấy phần tử ở đỉnh stack mà không xóa nó
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListStackIterator();
    }

    private class LinkedListStackIterator implements Iterator<E> {
        private Node current = stack;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            return element;
        }
    }

    public int size() {
        return size;
    }
}
