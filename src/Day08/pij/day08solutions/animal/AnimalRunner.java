package pij.day08solutions.animal;

import pij.day08solutions.box.Box;

// Exercise 9
public class AnimalRunner {
    public static void main(String[] args) {
        Box<Cat> catBox = new Box<>(new Cat()); // Box<Cat>, not Box<Animal>

        // The compiler rightly refuses the next line. If it were to allow it,
        // method doSomething(Box<Animal>) would be able to put a Dog object
        // into a Box<Cat>, which would break type safety.
        //Animal animal = AnimalHelper.doSomething(catBox);
    }
}
