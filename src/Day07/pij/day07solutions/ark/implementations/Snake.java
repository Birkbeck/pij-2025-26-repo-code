package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.EggLayer;

public class Snake extends AbstractAnimal implements EggLayer {
    public Snake(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Making snake sounds!");
    }
}
