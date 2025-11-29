package pij.day07solutions.measurable;

public class Day07Exercise05 {
    public static void main(String[] args) {
        Point p = new Point(3, 4);

        // ok, method getMeasure() exists in class Point
        System.out.println( p.getMeasure() );

        // ok, method getX() exists in class Point
        System.out.println( p.getX() );

        // ok, implicit upcasting from Point to Measurable
        Measurable m = p;

        // ok, method getMeasure() exists in type Measurable
        System.out.println( m.getMeasure() );

        // The following line is commented out because method getX() does
        // *not* exist in type Measurable (the compiler looks at the type
        // of the reference m; it does not know the content it might have
        // at runtime).
        //System.out.println( m.getX() );

    }
}
