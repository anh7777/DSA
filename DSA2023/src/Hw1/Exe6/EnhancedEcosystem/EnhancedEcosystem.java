package Hw1.Exe6.EnhancedEcosystem;
// P-2.32: Hệ sinh thái với giới tính và sức mạnh
//Đề bài:
//Mở rộng chương trình ở bài P-2.31 bằng cách thêm thuộc tính boolean gender (giới tính) và thuộc tính strength (sức mạnh dạng số thực) cho mỗi đối tượng động vật. Nếu hai động vật cùng loại và khác giới gặp nhau, chúng sẽ sinh ra động vật mới. Nếu chúng cùng giới, động vật có sức mạnh lớn hơn sẽ sống sót.

import java.util.Random;

public class EnhancedEcosystem {
    private Animal[] river;
    private Random random = new Random();

    public EnhancedEcosystem(int size) {
        river = new Animal[size];
        populateRiver();
    }

    private void populateRiver() {
        for (int i = 0; i < river.length; i++) {
            int rand = random.nextInt(3);
            if (rand == 0) river[i] = new Bear(random.nextBoolean(), random.nextDouble() * 10);
            else if (rand == 1) river[i] = new Fish(random.nextBoolean(), random.nextDouble() * 10);
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
                        handleSameTypeCollision(i, newPos);
                    } else if (river[i] instanceof Bear && river[newPos] instanceof Fish) {
                        river[newPos] = river[i];
                        river[i] = null;
                    }
                }
            }
        }
    }

    private void handleSameTypeCollision(int i, int newPos) {
        if (river[i].gender != river[newPos].gender) {
            int emptySpot = findEmptySpot();
            if (emptySpot != -1) {
                if (river[i] instanceof Bear) river[emptySpot] = new Bear(random.nextBoolean(), random.nextDouble() * 10);
                else river[emptySpot] = new Fish(random.nextBoolean(), random.nextDouble() * 10);
            }
        } else {
            if (river[i].strength > river[newPos].strength) river[newPos] = river[i];
            river[i] = null;
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
        EnhancedEcosystem ecosystem = new EnhancedEcosystem(10);
        for (int i = 0; i < 5; i++) {
            ecosystem.displayRiver();
            ecosystem.simulateStep();
        }
    }
}