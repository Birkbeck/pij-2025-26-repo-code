package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.EggLayer;
import pij.day07solutions.ark.FlyingAnimal;

public class Owl extends AbstractAnimal implements EggLayer, FlyingAnimal {
    public Owl(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Hoot");
    }
}
