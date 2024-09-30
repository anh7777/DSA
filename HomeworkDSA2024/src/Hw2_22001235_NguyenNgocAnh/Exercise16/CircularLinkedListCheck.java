package Hw2_22001235_NguyenNgocAnh.Exercise16;

public class CircularLinkedListCheck {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public boolean isCircular() {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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
        CircularLinkedListCheck cllCheck = new CircularLinkedListCheck();
        cllCheck.insert(1);
        cllCheck.insert(2);
        cllCheck.insert(3);
        cllCheck.head.next.next.next = cllCheck.head;

        System.out.println("Is Circular Linked List? " + cllCheck.isCircular());
    }
}
