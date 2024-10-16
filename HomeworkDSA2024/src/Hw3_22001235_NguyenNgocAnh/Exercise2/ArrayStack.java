package Hw3_22001235_NguyenNgocAnh.Exercise2;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackInterface<E>{
    public static final int CAPACITY = 100;
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
    public void push(E element) {
        if (top == stack.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = element;
    }

    @Override
    public E pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        E element = stack[top];
        stack[top--] = null;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public E top() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<E> {
        private int curIndex = top;
        @Override
        public boolean hasNext() {
            return curIndex >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stack[curIndex--];
        }
    }
}
