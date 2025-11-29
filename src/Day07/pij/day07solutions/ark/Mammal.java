package pij.day07solutions.ark;

public interface Mammal extends Animal {
    default void giveBirth() {
        System.out.println("Giving birth...");
    }

    default void reproduce() {
        giveBirth();
    }
}
