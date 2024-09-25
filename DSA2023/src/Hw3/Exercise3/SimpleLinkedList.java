package Hw3.Exercise3;

public class SimpleLinkedList<T> {
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node top = null;
    private Node bot = null;
    private int N = 0;

    public void add(T data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = bot = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        N++;
    }
    public void addBot(T data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = bot = newNode;
        } else {
            bot.next = newNode;
        }
        N++;
    }

    public T get(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException();
        }
        Node current = top;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    public boolean isContains(T data) {
        Node current = top;
        for (int i = 0; i < N; i++) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T removeTop() {
        if (isEmpty()) {
            return null;
        }

        T data = top.data;
        top = top.next;
        if (top == null) {
            bot = null;
        }
        N--;
        return data;
    }

    public T removeBot() {
        if (bot == null) {
            return null;
        }
        if (top == bot) {
            T data = top.data;
            top = bot = null;
            N--;
            return data;
        }

        Node current = top;
        while (current.next != bot) {
            current = current.next;
        }
        T data = bot.data;
        bot = current;
        bot.next = null;
        N--;
        return data;
    }

    public void remove(T data) {
        if (top == null) {
            return;
        }

        if (top.data.equals(data)) {
            removeTop();
            return;
        }

        Node current = top;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            if (current.next == null) {
                bot = current;
            }
            N--;
        }
    }
}
