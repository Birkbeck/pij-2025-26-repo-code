package pij.day08.animal;

public class Barker {
    public void makeAllDogsBarkTry1(Animal[] animals) {
        for (Animal animal : animals) {
            Dog dog = (Dog) animal;
            dog.bark();
        }
    }

    public void makeAllDogsBarkTry2(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal;
                dog.bark();
            }
        }
    }

    public void makeAllDogsBarkTry3(Animal[] animals) {
        for (Animal animal : animals) {
            if (animal instanceof Dog dog) {
                dog.bark();
            }
        }
    }
}
