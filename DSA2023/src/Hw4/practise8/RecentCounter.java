package Hw4.practise8;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        // Xóa các cuộc gọi cũ hơn 3000 giây
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size(); // Trả về số cuộc gọi gần đây
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));    // In ra 1
        System.out.println(counter.ping(100));  // In ra 1
        System.out.println(counter.ping(3001)); // In ra 2
        System.out.println(counter.ping(3002)); // In ra 3
    }
}
