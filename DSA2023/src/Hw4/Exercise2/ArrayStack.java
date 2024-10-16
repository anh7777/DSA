package Hw4.Exercise2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements StackInterface<E> {
    public static final int CAPACITY = 1000;  // Kích thước mặc định của stack
    private E[] stack;
    private int top;

    // Constructor mặc định
    public ArrayStack() {
        this(CAPACITY);  // Gọi constructor với kích thước mặc định
    }

    // Constructor với kích thước do người dùng chỉ định
    public ArrayStack(int capacity) {
        stack = (E[]) new Object[capacity];  // Khởi tạo stack với kích thước tùy chỉnh
        top = -1;  // Khởi tạo vị trí top là -1, nghĩa là stack trống
    }

    @Override
    public void push(E element) throws IllegalStateException {
        if (top == stack.length - 1) {
            throw new IllegalStateException("Stack is full");  // Kiểm tra xem stack có đầy không
        }
        stack[++top] = element;  // Tăng top và thêm phần tử mới
    }

    @Override
    public E pop() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");  // Kiểm tra stack trống
        }
        E element = stack[top];  // Lấy phần tử ở đỉnh
        stack[top--] = null;     // Xóa phần tử và giảm top
        return element;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;  // Kiểm tra xem stack có trống không
    }

    @Override
    public E top() {
        if (top == -1) {
            throw new IllegalStateException("Stack is empty");  // Kiểm tra stack trống
        }
        return stack[top];  // Trả về phần tử ở đỉnh nhưng không xóa nó
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    // Lớp iterator cho ArrayStack, duyệt từ trên xuống dưới
    private class ArrayStackIterator implements Iterator<E> {
        private int currentIndex = top;  // Bắt đầu từ đỉnh của stack

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;  // Kiểm tra còn phần tử để duyệt không
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();  // Nếu không còn phần tử, ném ngoại lệ
            }
            return stack[currentIndex--];  // Trả về phần tử và giảm chỉ số
        }
    }
}
