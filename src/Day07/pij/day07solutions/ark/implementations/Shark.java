package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.AquaticAnimal;
import pij.day07solutions.ark.EggLayer;

public class Shark extends AbstractAnimal implements AquaticAnimal, EggLayer {
    public Shark(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Making shark sound!");
    }
}
