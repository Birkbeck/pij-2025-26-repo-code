package pij.day09solutions.animal;

import pij.day08solutions.animal.Animal;
import pij.day08solutions.animal.Dog;
import pij.day08solutions.box.Box;

// Ex 11
public class AnimalHelper {
    public static Animal doSomething(Box<? extends Animal> animalBox) {
        // Ex 11: compiler says no: animalBox might be a reference
        // to a Box<Cat>, which is not allowed to contain new Animal()
        //animalBox.setData(new Animal());

        // Ex 11: compiler says no: animalBox might be a reference
        // to a Box<Cat>, which is not allowed to contain new Dog()
        //animalBox.setData(new Dog());
        return animalBox.getData();
    }
}
