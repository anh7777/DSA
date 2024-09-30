package Hw2_22001235_NguyenNgocAnh.Exercise10;

public class ReverseLinkedList {
    class Node {
        int data;
        Node next;

        Node(int newData) {
            data = newData;
            next = null;
        }
    }

    public Node reverse(Node head) {
        Node newHead = null;
        while (head != null) {
            Node temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);

        System.out.println("Original List:");
        list.printList(head);

        head = list.reverse(head);
        System.out.println("Reversed List:");
        list.printList(head);
    }
}
