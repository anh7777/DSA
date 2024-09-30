package Hw2_22001235_NguyenNgocAnh.Exercise7;
//[Cách tiếp cận ngây thơ(Naive Approach)]Tìm độ dài của danh sách – Hai lần duyệt – O(M) Thời gian và O(1) Không gian
//Ý tưởng là đếm số lượng nút trong danh sách liên kết ở lần duyệt đầu tiên, chẳng hạn như len . Ở lần duyệt thứ hai, trả về nút thứ (len – n + 1) tính từ đầu Danh sách liên kết.

public class NaiveApproach {
    private class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    public int findNthFromLast(Node head, int N) {
        int len = 0;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            len++;
        }

        if (len < N)
            return -1;

        temp = head;

        for (int i = 1; i < len - N + 1; i++)
            temp = temp.next;

        return temp.data;
    }

    public static void main(String[] args) {
        NaiveApproach list = new NaiveApproach();

        // Create a hard-coded linked list: 35 -> 15 -> 4 -> 20
        Node head = list.new Node(35);
        head.next = list.new Node(15);
        head.next.next = list.new Node(4);
        head.next.next.next = list.new Node(20);

        // Function Call to find the 4th node from end
        System.out.println(list.findNthFromLast(head, 4));
    }
}