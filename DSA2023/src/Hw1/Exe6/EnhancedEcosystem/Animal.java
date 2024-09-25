package Hw1.Exe6.EnhancedEcosystem;

abstract class Animal {
    boolean gender;
    double strength;

    Animal(boolean gender, double strength) {
        this.gender = gender;
        this.strength = strength;
    }

    abstract String getType();
}
