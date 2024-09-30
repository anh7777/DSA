package Hw2_22001235_NguyenNgocAnh.Exercise16;

public class SortedInsertCircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void sortedInsert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else if (data <= head.data) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head && current.next.data < data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
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
        SortedInsertCircularLinkedList cll = new SortedInsertCircularLinkedList();
        cll.sortedInsert(3);
        cll.sortedInsert(1);
        cll.sortedInsert(2);
        cll.sortedInsert(4);

        System.out.println("Sorted Circular Linked List:");
        cll.traverse();
    }
}
