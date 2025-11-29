package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.EggLayer;

public class Lizard extends AbstractAnimal implements EggLayer {
    public Lizard(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Making lizard sounds!");
    }
}
