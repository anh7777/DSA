package Hw3_22001235_NguyenNgocAnh.Exercise2;

import java.util.Iterator;

public class LinkedListStack <E> implements StackInterface <E > {
    class Node {
        E element;
        Node next;

        Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    private Node stack = null;
    private int size = 0;

    @Override
    public void push(E element) {
        if (stack == null) {
            stack = new Node(element, null);
        } else {
            Node newNode = new Node(element, stack);
            stack = newNode;
        }
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E topElement = stack.element;
        stack = stack.next;
        size--;
        return topElement;
    }

    @Override
    public boolean isEmpty() {
        return stack == null;
    }

    @Override
    public E top() {
        if (isEmpty()) {
            return null;
        }
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new StackIterator();
    }

    class StackIterator implements Iterator<E> {
        private Node currentNode = stack;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }
        @Override
        public E next() {
            E data = currentNode.element;
            currentNode = currentNode.next;
            return data;
        }
    }
}
