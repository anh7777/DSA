package Hw2_22001235_NguyenNgocAnh.Exercise7;

public class CountLinkedListNodes {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int countNodes(Node head) {
        int count = 0;
        Node current = head;

        // Traverse the linked list
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public static void main(String[] args) {
        CountLinkedListNodes list = new CountLinkedListNodes();

        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);

        System.out.println(list.countNodes(head));
    }
}
