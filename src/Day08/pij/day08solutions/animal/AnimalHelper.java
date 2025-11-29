package pij.day08solutions.animal;

import pij.day08solutions.box.Box;

public class AnimalHelper {
    public static Animal doSomething(Box<Animal> animalBox) {
        // Ex 7: compiler accepts the following line because an Animal
        // reference is provided where an Animal reference is expected
        animalBox.setData(new Animal());

        // Ex 7: compiler accepts the following line because a Dog
        // reference is provided where an Animal reference is expected,
        // and Dog is a subtype of Animal
        animalBox.setData(new Dog());
        return animalBox.getData();
    }
}
