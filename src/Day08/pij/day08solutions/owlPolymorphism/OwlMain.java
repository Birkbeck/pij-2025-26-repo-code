package pij.day08solutions.owlPolymorphism;

import pij.day08.owlPolymorphism.Bird;
import pij.day08.owlPolymorphism.Owl;

public class OwlMain {
    public static void main(String[] args) {
        Bird b = new Bird();
        Owl o = new Owl();
        Bird owlAsBird = o;

        // The compiler sees the type Bird and the method signature print().
        // It selects the implementation (!) of the static method print() in
        // type Bird. The JVM runs this method.
        Bird.print(); // prints: bird

        // The compiler sees the type Owl and the method signature print().
        // It selects the implementation (!) of the static method print() in
        // type Owl. The JVM runs this method.
        Owl.print(); // prints: owl

        // you can call static methods also via object references
        // (calling them via the class name is clearer)


        // The compiler sees that the reference b has type Bird and checks whether
        // it has a method signature print().
        // It selects the implementation (!) of the static method print() in
        // type Bird. The JVM runs this method.
        b.print(); // prints: bird


        // The compiler sees that the reference o has type Owl and checks whether
        // it has a method signature print().
        // It selects the implementation (!) of the static method print() in
        // type Owl. The JVM runs this method.
        o.print(); // prints: owl


        // The compiler sees that the reference owlAsBird has type Bird and
        // checks whether this type has a method signature print().
        // It selects the implementation (!) of the static method print() in
        // type Bird. The JVM runs this method.
        owlAsBird.print(); // prints: bird
    }
}
