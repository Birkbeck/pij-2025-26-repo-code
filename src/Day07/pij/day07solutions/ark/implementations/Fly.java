package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.EggLayer;
import pij.day07solutions.ark.FlyingAnimal;

public class Fly extends AbstractAnimal implements EggLayer, FlyingAnimal {

    public Fly(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Bzzzz");
    }
}
