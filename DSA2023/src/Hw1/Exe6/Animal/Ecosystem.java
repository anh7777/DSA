package Hw1.Exe6.Animal;
// P-2.31: Mô phỏng hệ sinh thái
//Đề bài:
//Viết chương trình mô phỏng một hệ sinh thái có chứa hai loài sinh vật là gấu và cá trong một con sông. Sông được mô hình hóa bằng một mảng, trong đó mỗi ô có thể chứa một đối tượng động vật (gấu hoặc cá), hoặc có thể là null (trống). Tại mỗi bước thời gian, mỗi động vật sẽ ngẫu nhiên di chuyển hoặc ở nguyên vị trí. Nếu hai động vật cùng loại đụng nhau, chúng sẽ sinh ra một động vật mới. Nếu gấu và cá đụng nhau, cá sẽ chết.

import java.util.Random;

public class Ecosystem {
    private Animal[] river;
    private Random random = new Random();

    public Ecosystem(int size) {
        river = new Animal[size];
        populateRiver();
    }

    private void populateRiver() {
        for (int i = 0; i < river.length; i++) {
            int rand = random.nextInt(3);
            if (rand == 0) river[i] = new Bear();
            else if (rand == 1) river[i] = new Fish();
        }
    }

    public void simulateStep() {
        for (int i = 0; i < river.length; i++) {
            if (river[i] != null) {
                int move = random.nextInt(3) - 1; // -1, 0, 1
                int newPos = i + move;
                if (newPos >= 0 && newPos < river.length) {
                    if (river[newPos] == null) {
                        river[newPos] = river[i];
                        river[i] = null;
                    } else if (river[i].getType().equals(river[newPos].getType())) {
                        int emptySpot = findEmptySpot();
                        if (emptySpot != -1) {
                            if (river[i] instanceof Bear) river[emptySpot] = new Bear();
                            else river[emptySpot] = new Fish();
                        }
                    } else if (river[i] instanceof Bear && river[newPos] instanceof Fish) {
                        river[newPos] = river[i];
                        river[i] = null;
                    }
                }
            }
        }
    }

    private int findEmptySpot() {
        for (int i = 0; i < river.length; i++) {
            if (river[i] == null) return i;
        }
        return -1;
    }

    public void displayRiver() {
        for (Animal a : river) {
            if (a == null) System.out.print("_ ");
            else System.out.print(a.getType().charAt(0) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem ecosystem = new Ecosystem(10);
        for (int i = 0; i < 5; i++) {
            ecosystem.displayRiver();
            ecosystem.simulateStep();
        }
    }
}