package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.EggLayer;

public class Beetle extends AbstractAnimal implements EggLayer {

    public Beetle(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Buzz");
    }
}
