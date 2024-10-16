package Hw3_22001235_NguyenNgocAnh.Exercise4;

public class TestArrayQueue {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        for (Integer item : queue) {
            System.out.println(item);
        }

        System.out.println("Kích thước hàng đợi: " + queue.size());
        System.out.println("Phần tử ở đầu hàng đợi: " + queue.peek());
    }
}
