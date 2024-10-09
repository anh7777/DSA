package Hw4.practise10;

class CircularDeque {
    private int[] deque;
    private int front, rear, size;

    public CircularDeque(int k) {
        deque = new int[k];
        front = rear = -1;
        size = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + size) % size;
        deque[front] = value;
        if (rear == -1) rear = front; // Khi deque lần đầu được thêm phần tử
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % size;
        deque[rear] = value;
        if (front == -1) front = rear; // Khi deque lần đầu được thêm phần tử
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (front == rear) {
            front = rear = -1; // Xóa phần tử cuối cùng
        } else {
            front = (front + 1) % size;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (front == rear) {
            front = rear = -1; // Xóa phần tử cuối cùng
        } else {
            rear = (rear - 1 + size) % size;
        }
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}
