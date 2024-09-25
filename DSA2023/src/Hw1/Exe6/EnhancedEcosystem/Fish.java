package Hw1.Exe6.EnhancedEcosystem;

class Fish extends Animal {
    Fish(boolean gender, double strength) {
        super(gender, strength);
    }

    @Override
    String getType() {
        return "Fish";
    }
}