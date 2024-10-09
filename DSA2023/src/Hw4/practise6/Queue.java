package Hw4.practise6;

class Queue {
    private Node front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Thêm phần tử vào hàng đợi
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Xóa phần tử từ hàng đợi
    public int dequeue() {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    // Kiểm tra hàng đợi có rỗng không
    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.dequeue()); // In ra 10
        System.out.println(queue.isEmpty()); // In ra false
    }
}