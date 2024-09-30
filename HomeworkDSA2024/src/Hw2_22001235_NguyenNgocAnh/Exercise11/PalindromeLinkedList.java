package Hw2_22001235_NguyenNgocAnh.Exercise11;

public class PalindromeLinkedList {
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

    public boolean isPalindrome(Node head) {
        if (head == null) return true;

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reversedHalf = reverse(slow);
        Node firstHalf = head;

        while (reversedHalf != null) {
            if (firstHalf.data != reversedHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            reversedHalf = reversedHalf.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(2);
        head.next.next.next = list.new Node(1);

        System.out.println("Is Palindrome: " + list.isPalindrome(head));
    }
}
