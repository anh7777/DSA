package Hw2_22001235_NguyenNgocAnh.Exercise5.Exe3;

import java.util.Scanner;

public class CircularLinkedList {
    public static Node createNode(int x) {
        return new Node(x);
    }

    public static void printList(Node l, int k) {
        Node p = l;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        System.out.print(p.data + " ");
        Node p2 = p.next;
        while (p2 != p) {
            System.out.print(p2.data + " ");
            p2 = p2.next;
        }
        System.out.println();
    }

    public static Node addTail(Node l, int x) {
        Node p = l;
        while (p.next != l) {
            p = p.next;
        }
        Node temp = new Node(x);
        temp.next = l;
        p.next = temp;
        return l;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        Node l = createNode(x);
        for (int i = 1; i < n; i++) {
            x = scanner.nextInt();
            l = addTail(l, x);
        }
        int k = scanner.nextInt();
        printList(l, k);
        scanner.close();
    }
}