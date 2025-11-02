package pij.day08solutions.pair;

/** Runner for class Pair, exercising all constructors and methods. */
public class PairRunner {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Hello", 1);
        System.out.println("pair1.x: " + pair1.getX());
        System.out.println("pair1.y: " + pair1.getY());

        Pair<String, Integer> pair2 = new Pair<>(pair1);
        System.out.println("pair2.x: " + pair2.getX());
        System.out.println("pair2.y: " + pair2.getY());

        Pair<Integer, String> swappedPair = pair2.swap();
        System.out.println("swappedPair.x: " + swappedPair.getX());
        System.out.println("swappedPair.y: " + swappedPair.getY());
    }
}
