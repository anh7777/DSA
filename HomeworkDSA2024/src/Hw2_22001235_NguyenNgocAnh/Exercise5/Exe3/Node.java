package Hw2_22001235_NguyenNgocAnh.Exercise5.Exe3;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = this;
    }
}
