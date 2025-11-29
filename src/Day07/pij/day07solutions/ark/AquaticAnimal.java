package pij.day07solutions.ark;

public interface AquaticAnimal extends Animal {
    default void call() {
        System.out.println(getName() + " will not come...");
    }
}
