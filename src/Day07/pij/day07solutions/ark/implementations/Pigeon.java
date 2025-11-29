package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.EggLayer;
import pij.day07solutions.ark.FlyingAnimal;

public class Pigeon extends AbstractAnimal implements EggLayer, FlyingAnimal {
    public Pigeon(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Coo");
    }
}
