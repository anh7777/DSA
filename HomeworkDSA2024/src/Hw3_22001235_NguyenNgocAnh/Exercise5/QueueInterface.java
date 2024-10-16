package Hw3_22001235_NguyenNgocAnh.Exercise5;

public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
