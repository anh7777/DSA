package Hw2_22001235_NguyenNgocAnh.Exercise5.Exe2;

import java.util.Scanner;

public class Main {
    public static DoublyLinkedList createList(int x) {
        return new DoublyLinkedList(x);
    }

    public static DoublyLinkedList addHead(DoublyLinkedList l, int x) {
        Node temp = new Node(x);
        temp.next = l.head;
        l.head.pre = temp;
        l.head = temp;
        return l;
    }

    public static DoublyLinkedList addTail(DoublyLinkedList l, int x) {
        Node temp = new Node(x);
        temp.pre = l.tail;
        l.tail.next = temp;
        l.tail = temp;
        return l;
    }

    public static void printList(DoublyLinkedList l) {
        Node p = l.head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DoublyLinkedList l = createList(1);
        for (int i = 2; i <= n; i++) {
            l = addHead(l, i);
            l = addTail(l, i);
        }
        printList(l);
        scanner.close();
    }
}