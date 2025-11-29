package pij.day07solutions.ark.implementations;

import pij.day07solutions.ark.AbstractAnimal;
import pij.day07solutions.ark.Mammal;

public class Bear extends AbstractAnimal implements Mammal {

    public Bear(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Groar!");
    }
}
