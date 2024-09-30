package Hw2_22001235_NguyenNgocAnh.Exercise9;

public class OccurrenceInLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int countOccurrences(Node head, int key) {
        int count = 0;
        Node current = head;

        while (current != null) {
            if (current.data == key) {
                count++;
            }
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        OccurrenceInLinkedList list = new OccurrenceInLinkedList();

        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(1);
        head.next.next.next = list.new Node(2);
        head.next.next.next.next = list.new Node(1);
        head.next.next.next.next.next = list.new Node(3);
        head.next.next.next.next.next.next = list.new Node(1);

        int key = 1;
        System.out.println("The occurrences of " + key + " in the linked list: " + list.countOccurrences(head, key)); // Output: 4

        key = 3;
        System.out.println("The occurrences of " + key + " in the linked list: " + list.countOccurrences(head, key)); // Output: 1

        key = 5;
        System.out.println("The occurrences of " + key + " in the linked list: " + list.countOccurrences(head, key)); // Output: 0
    }
}
