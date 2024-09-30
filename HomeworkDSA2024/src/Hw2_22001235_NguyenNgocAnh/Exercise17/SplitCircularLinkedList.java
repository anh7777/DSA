package Hw2_22001235_NguyenNgocAnh.Exercise17;

public class SplitCircularLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void splitList() {
        if (head == null) return;

        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node head1 = head;
        Node head2 = slow.next;

        slow.next = head1;
        fast.next = head2;

        System.out.println("First Half:");
        printList(head1);
        System.out.println("Second Half:");
        printList(head2);
    }

    public void printList(Node head) {
        if (head == null) return;

        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to head)");
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

    public static void main(String[] args) {
        SplitCircularLinkedList cll = new SplitCircularLinkedList();
        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);

        System.out.println("Original Circular Linked List:");
        cll.printList(cll.head);

        cll.splitList();
    }
}

