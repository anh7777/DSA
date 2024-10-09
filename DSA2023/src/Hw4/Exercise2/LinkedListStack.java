package Hw4.Exercise2;

import java.util.Iterator;
import java.util.Stack;

public class LinkedListStack<E> implements StackInterface<E> {
    class Node {
        E element;
        Node next;
    }
    private Node stack = null;

    @Override
    public void push(E element) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public E top() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
