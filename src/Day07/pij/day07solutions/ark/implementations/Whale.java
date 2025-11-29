package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.AquaticAnimal;
import pij.day07solutions.ark.Mammal;

public class Whale extends AbstractAnimal implements AquaticAnimal, Mammal {
    public Whale(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Making whale sound!");
    }
}
