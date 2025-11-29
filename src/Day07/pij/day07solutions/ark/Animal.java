package pij.day07solutions.ark;

// Ex 11
public interface Animal {

    String getName();

    default void call() {
        System.out.println(getName() + " coming...");
    }

    void reproduce();

    void makeSound();
}
