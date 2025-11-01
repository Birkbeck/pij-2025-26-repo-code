package pij.day09.intRememberer;

/**
 * Runner class for IntRememberer.
 */
public class IntRemembererRunner {
    public static void check(IntRememberer rememberer, int checkMe) {
        boolean isKnown = rememberer.knows(checkMe);
        System.out.println(checkMe + " is " + (isKnown ? "" : "NOT ") + "known!");
    }
    public static void main(String[] args) {
        IntRememberer rememberer = new IntRememberer();
        rememberer.makeKnown(2);
        rememberer.makeKnown(3);
        check(rememberer, 2);
        check(rememberer, -10);
    }
}
