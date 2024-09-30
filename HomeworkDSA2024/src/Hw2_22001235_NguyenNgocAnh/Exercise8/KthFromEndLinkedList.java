package Hw2_22001235_NguyenNgocAnh.Exercise8;

public class KthFromEndLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public int findKthFromEnd(Node head, int k) {
        Node main_ptr = head;
        Node ref_ptr = head;

        for (int i = 0; i < k; i++) {
            if (ref_ptr == null) {
                return -1;
            }
            ref_ptr = ref_ptr.next;
        }

        while (ref_ptr != null) {
            main_ptr = main_ptr.next;
            ref_ptr = ref_ptr.next;
        }

        return main_ptr.data;
    }

    public static void main(String[] args) {
        KthFromEndLinkedList list = new KthFromEndLinkedList();

        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);
        head.next.next.next.next.next = list.new Node(6);
        head.next.next.next.next.next.next = list.new Node(7);
        head.next.next.next.next.next.next.next = list.new Node(8);
        head.next.next.next.next.next.next.next.next = list.new Node(9);

        int k = 2;
        System.out.println("The " + k + "th node from the end is: " + list.findKthFromEnd(head, k));

        k = 5;
        System.out.println("The " + k + "th node from the end is: " + list.findKthFromEnd(head, k));

        k = 10;
        System.out.println("The " + k + "th node from the end is: " + list.findKthFromEnd(head, k)); // Output: -1
    }
}
