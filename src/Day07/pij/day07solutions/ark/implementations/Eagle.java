package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.EggLayer;
import pij.day07solutions.ark.FlyingAnimal;

public class Eagle extends AbstractAnimal implements EggLayer, FlyingAnimal {

    public Eagle(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Cree");
    }
}
