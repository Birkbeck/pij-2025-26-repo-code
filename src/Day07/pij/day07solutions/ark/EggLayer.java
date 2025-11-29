package pij.day07solutions.ark;

public interface EggLayer extends Animal {
    default void layEggs() {
        System.out.println("Laying eggs...");
    }

    default void reproduce() {
        layEggs();
    }
}
