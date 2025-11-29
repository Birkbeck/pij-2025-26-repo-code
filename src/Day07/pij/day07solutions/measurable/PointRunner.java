package pij.day07solutions.measurable;

public class PointRunner {
    public static void main(String[] args) {
        Point p = new Point(3, 4);
        System.out.println( p.getMeasure() ); // ok, method is in class Point
        System.out.println( p.getX() ); // ok, method is in class Point
        Measurable m = p;

        // The next line is accepted by the compiler: method getMeasure()
        // is declared in interface Measurable.
        System.out.println( m.getMeasure() );

        // The next line is rejected by the compiler.
        // Type Measurable does not have a method getX().
        //System.out.println( m.getX() );
    }
}
