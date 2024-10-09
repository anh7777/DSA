package Hw4.practise9;

class CircularQueue {
    private int[] queue;
    private int front, rear, size;

    public CircularQueue(int k) {
        queue = new int[k];
        front = rear = 0;
        size = k;
    }

    public boolean enqueue(int value) {
        if ((rear + 1) % size == front) {
            return false; // Hàng đợi đầy
        }
        queue[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }

    public boolean dequeue() {
        if (front == rear) {
            return false; // Hàng đợi rỗng
        }
        front = (front + 1) % size;
        return true;
    }

    public int getFront() {
        return queue[front];
    }

    public int getRear() {
        return queue[(rear - 1 + size) % size];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % size == front;
    }
}