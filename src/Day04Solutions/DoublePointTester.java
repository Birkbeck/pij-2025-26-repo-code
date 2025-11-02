public class DoublePointTester {
    // helper method
    public static void print(DoublePoint p1, DoublePoint p2) {
        System.out.println("p1 = " + p1.toString() + "; p2 = " + p2.toString());
    }

    // helper method (overloading the name "print")
    public static void print(DoublePoint p1, DoublePoint p2, DoublePoint p3) {
        System.out.println("p1 = " + p1.toString() + "; p2 = " + p2.toString()
                + "; p3 = " + p3.toString());
    }

    public static void main(String[] args) {
        DoublePoint p1 = new DoublePoint(2, 3);
        DoublePoint p2 = new DoublePoint(5, 7);
        print(p1, p2);
        System.out.println("Distance p1 to p2: " + p1.distanceTo(p2));
        System.out.println("Distance p2 to p1: " + p2.distanceTo(p1));
        System.out.println("Distance p1 to origin: " + p1.distanceToOrigin());
        System.out.println("Distance p2 to origin: " + p2.distanceToOrigin());
        p2.moveTo(p1);
        print(p1, p2);
        p1.moveTo(8, 9);
        print(p1, p2);
        DoublePoint p3 = p1.copy();
        print(p1, p2, p3);
        p3.moveTo(-2, 5); // should not affect p1
        print(p1, p2, p3);
        p3 = p1.opposite();
        print(p1, p2, p3);
        p3.moveTo(-3, 6); // should not affect p1
        print(p1, p2, p3);
    }
}
