package phan2;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings({"unchecked", "deprecation"})
public class SimpleLinkedList<T> implements ListInterface<T> {
    class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    @Override
    public void add(T data) {
        // TODO Auto-generated method stub
        Node newNode = new Node(data);
        if (n == 0) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }
        n++;
    }
    @Override
    public T get(int i) {
        // TODO Auto-generated method stub
        if (i < 0 || i >= n) {
            return null;
        }
        Node cur = top;
        for (int j = 0; j < i; j ++) {
            cur = cur.next;
        }
        return cur.data;
    }
    @Override
    public void set(int i, T data) {
        // TODO Auto-generated method stub
        if (i < 0 || i >= n) {
            return;
        }
        Node cur = top;
        for (int j = 0; j < i; j++) {
            cur = cur.next;
        }
        cur.data = data;
    }
    @Override
    public void remove(int i) {
        // TODO Auto-generated method stub
        if (i < 0 || i >= n) {
            return;
        }
        if (i == 0) {
            top = top.next;
            if (n == 1) {
                bot = null;
            }
        } else {
            Node cur = top;
            for (int j = 0; j < i - 1; j++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if (cur.next == null) {
                bot = cur;
            }
        }
        n--;
    }
    @Override
    public boolean isContain(T data) {
        // TODO Auto-generated method stub
        Node cur = top;
        for (int j = 0; j < n; j ++) {
            if (cur.data.equals(data)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    @Override
    public int indexOf(T data) {
        // TODO Auto-generated method stubNode  p = top;
        Node cur = top;
        for (int j = 0; j < n; j++) {
            if (cur.data.equals(data)) {
                return j;
            }
            cur = cur.next;
        }
        return -1;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return n;
    }
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return n==0;
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator<T>{
        private Node current = top;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public T next() {
            // TODO Auto-generated method stub
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T data = current.data;
            current = current.next;
            return data;
        }

    }

}
