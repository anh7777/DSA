package Hw1.Exe6.EnhancedEcosystem;

class Bear extends Animal {
    Bear(boolean gender, double strength) {
        super(gender, strength);
    }

    @Override
    String getType() {
        return "Bear";
    }
}
