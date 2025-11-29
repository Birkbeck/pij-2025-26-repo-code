package pij.day07solutions.guitar;

/**
 * A Guitar is both a MusicalInstrument and a WoodenObject (Ex 7).
 * Represented by implementing two corresponding interfaces.
 */
public class Guitar implements MusicalInstrument, WoodenObject {
    @Override
    public void play() {
        System.out.println("Playing the guitar!");
    }

    @Override
    public void burn() {
        System.out.println("Burning the guitar!");
    }
}
