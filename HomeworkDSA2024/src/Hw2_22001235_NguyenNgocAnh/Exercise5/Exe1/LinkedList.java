package Hw2_22001235_NguyenNgocAnh.Exercise5.Exe1;

import java.util.Scanner;

public class LinkedList {
    public static Node createNode(int x) {
        return new Node(x);
    }

    public static void printList(Node l) {
        Node p = l;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node addElement(Node p, int x) {
        Node temp = createNode(x);
        p.next = temp;
        return temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, x;

        System.out.print("Nhập số lượng nút: ");
        n = scanner.nextInt();
        System.out.print("Nhập giá trị của nút đầu tiên: ");
        x = scanner.nextInt();

        Node l = createNode(x);
        Node p = l;

        for (int i = 1; i < n; i++) {
            System.out.print("Nhập giá trị của nút tiếp theo: ");
            x = scanner.nextInt();
            p = addElement(p, x);
        }

        printList(l);
        scanner.close();
    }
}