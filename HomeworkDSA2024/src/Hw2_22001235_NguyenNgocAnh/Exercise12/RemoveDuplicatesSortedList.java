package Hw2_22001235_NguyenNgocAnh.Exercise12;

public class RemoveDuplicatesSortedList {
    class Node {
        int data;
        Node next;

        Node(int newData) {
            data = newData;
            next = null;
        }
    }

    public Node removeDuplicates(Node head) {
        if (head == null) return null;

        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveDuplicatesSortedList list = new RemoveDuplicatesSortedList();
        Node head = list.new Node(1);
        head.next = list.new Node(1);
        head.next.next = list.new Node(2);
        head.next.next.next = list.new Node(3);
        head.next.next.next.next = list.new Node(3);

        System.out.println("Original List:");
        list.printList(head);

        head = list.removeDuplicates(head);
        System.out.println("List after removing duplicates:");
        list.printList(head);
    }
}
