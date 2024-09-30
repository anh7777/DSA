package Hw2_22001235_NguyenNgocAnh.Exercise7;

// [Cách tiếp cận dự kiến] Sử dụng hai con trỏ – Một lần truyền – Thời gian O(M) và Không gian O(1)
// Ý tưởng là duy trì hai con trỏ, giả sử main_ptr và ref_ptr trỏ đến đầu của Danh sách liên kết và di chuyển ref_ptr đến nút thứ N từ đầu để đảm bảo khoảng cách giữa main_ptr và ref_ptr là (N – 1).

public class ExpectedApproach {
    class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    int nthFromEnd(Node head, int N) {
        Node main_ptr = head;
        Node ref_ptr = head;

        for (int i = 1; i < N; i++) {
            ref_ptr = ref_ptr.next;

            if (ref_ptr == null) {
                return -1;
            }
        }

        while (ref_ptr.next != null) {
            ref_ptr = ref_ptr.next;
            main_ptr = main_ptr.next;
        }

        return main_ptr.data;
    }

    public static void main(String[] args) {
        ExpectedApproach list = new ExpectedApproach();

        Node head = list.new Node(35);
        head.next = list.new Node(15);
        head.next.next = list.new Node(4);
        head.next.next.next = list.new Node(20);

        System.out.println(list.nthFromEnd(head, 4));
    }
}
