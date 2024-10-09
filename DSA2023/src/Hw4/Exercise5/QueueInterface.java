package Hw4.Exercise5;

public interface QueueInterface<E> extends Iterable<E> {
    void enqueue(E element);
    E dequeue();
    boolean isEmpty();
}
