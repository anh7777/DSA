package Hw2_22001235_NguyenNgocAnh.Exercise16;

public class DeleteAndReverseCircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void delete(int key) {
        if (head == null) return;

        Node current = head, prev = null;

        do {
            if (current.data == key) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    Node temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = current.next;
                    temp.next = head;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void reverse() {
        if (head == null) return;

        Node prev = null, current = head, next = null;
        Node tail = head;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != head);

        head.next = prev;
        head = prev;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void traverse() {
        if (head == null) return;

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        DeleteAndReverseCircularLinkedList cll = new DeleteAndReverseCircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);

        System.out.println("Original Circular Linked List:");
        cll.traverse();

        cll.delete(3);
        System.out.println("After deleting 3:");
        cll.traverse();

        cll.reverse();
        System.out.println("After reversing:");
        cll.traverse();
    }
}
