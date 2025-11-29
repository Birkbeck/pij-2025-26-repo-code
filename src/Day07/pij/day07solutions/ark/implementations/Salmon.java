package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.AquaticAnimal;
import pij.day07solutions.ark.EggLayer;

public class Salmon extends AbstractAnimal implements AquaticAnimal, EggLayer {
    public Salmon(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Making salmon sound!");
    }
}
