package pij.day07solutions.ark;

import pij.day07solutions.ark.implementations.Bear;
import pij.day07solutions.ark.implementations.Beetle;
import pij.day07solutions.ark.implementations.Cat;
import pij.day07solutions.ark.implementations.Crocodile;
import pij.day07solutions.ark.implementations.Dog;
import pij.day07solutions.ark.implementations.Dolphin;
import pij.day07solutions.ark.implementations.Eagle;
import pij.day07solutions.ark.implementations.Fly;
import pij.day07solutions.ark.implementations.Frog;
import pij.day07solutions.ark.implementations.Lizard;
import pij.day07solutions.ark.implementations.Monkey;
import pij.day07solutions.ark.implementations.Owl;
import pij.day07solutions.ark.implementations.Pigeon;
import pij.day07solutions.ark.implementations.Salmon;
import pij.day07solutions.ark.implementations.Snake;
import pij.day07solutions.ark.implementations.Whale;

public class ArkRunner {
    public static void run() {
        Animal[] animals = {
                new Bear("Paddington"),
                new Beetle("Bill"),
                new Cat("Larry"),
                new Crocodile("Dundee"),
                new Dog("Lassie"),
                new Dolphin("Flipper"),
                new Eagle("Sam"),
                new Fly("Buzz"),
                new Frog("Kermit"),
                new Lizard("Lee"),
                new Monkey("Mr Teeny"),
                new Owl("Hootie"),
                new Pigeon("Messenger"),
                new Salmon("Sal"),
                new Snake("Jailbird"),
                new Whale("Kimolu")
        };
        for (Animal animal : animals) {
            animal.call();
            animal.makeSound();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
