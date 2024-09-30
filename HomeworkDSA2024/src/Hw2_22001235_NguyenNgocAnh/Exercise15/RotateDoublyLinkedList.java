package Hw2_22001235_NguyenNgocAnh.Exercise15;

public class RotateDoublyLinkedList {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    public void rotate(int k) {
        if (head == null || head.next == null || k == 0) return;

        Node current = head;
        int count = 1;

        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if (current == null) return;

        Node kthNode = current;
        Node kthNext = kthNode.next;

        if (kthNext == null) return;

        head = kthNext;

        while (kthNext.next != null) {
            kthNext = kthNext.next;
        }

        kthNext.next = head;
        head.prev = kthNext;
        kthNode.next = null;
        kthNode.prev = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RotateDoublyLinkedList dll = new RotateDoublyLinkedList();
        dll.insert(1);
        dll.insert(2);
        dll.insert(3);
        dll.insert(4);
        dll.insert(5);

        System.out.println("Original Doubly Linked List:");
        dll.printList();

        int k = 2;
        dll.rotate(k);
        System.out.println("Doubly Linked List after rotating by " + k + " nodes:");
        dll.printList();
    }
}
