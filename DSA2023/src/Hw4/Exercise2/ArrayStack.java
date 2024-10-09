package Hw4.Exercise2;

import java.util.Iterator;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000;
    private E[] stack;
    private int top;
    public ArrayStack() {
        stack = (E[]) new Object[CAPACITY];
        top = -1;
    }
    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];
        top = -1;
    }
    @Override
    public void push(E element) throws IllegalStateException {
        if (top == stack.length - 1) {
            throw new IllegalStateException("Stack is full");
        }
        stack[++top] = element;
    }

    @Override
    public E pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        E element = stack[top--];
        stack[top] = null;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public E top() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
