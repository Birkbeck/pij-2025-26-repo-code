package pij.day13.triangle;

/**
 * Class with a static method to print a Triangle on the screen. 
 */
public class TrianglePrinter {

    /**
     * Prints a Triangle of a given width on the screen.
     * Does nothing if width is zero or negative.
     * Uses recursion.
     *
     * @param width  the length of the triangle to print
     */
    public static void printTriangle(int width) {
        if (width <= 0) {
            return;
        }
        printTriangle(width - 1);
        for (int i = 0; i < width; i++) {
            System.out.print("[]");
        }
        System.out.println();
    }

    /**
     * Prints a Triangle of a given width on the screen.
     * Does nothing if width is zero or negative.
     * Uses recursion. Uses a StringBuilder internally.
     *
     * @param width  the length of the triangle to print
     */
    public static void printTriangleWithStringBuilder(int width) {
        if (width <= 0) {
            return;
        }
        printTriangleWithStringBuilder(width - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append("[]");
        }
        System.out.println(sb.toString());
    }


    /**
     * Prints a Triangle of a given width on the screen.
     * Does nothing if width is zero or negative.
     * Uses recursion. Uses the <code>repeat</code>
     * method of class String.
     *
     * @param width  the length of the triangle to print
     */
    public static void printTriangleWithRepeat(int width) {
        if (width <= 0) {
            return;
        }
        printTriangleWithRepeat(width - 1);
        System.out.println("[]".repeat(width));
    }

    /**
     * Prints a Triangle of a given width on the screen.
     * Does nothing if width is zero or negative.
     * Does not use recursion.
     *
     * @param width  the length of the triangle to print
     */
    public static void printTriangleLoopsOnly(int width) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("[]");
            }
            System.out.println();
        }
    }

    /**
     * Driver method to test printTriangle.
     * @param args  ignored
     */
    public static void main(String[] args) {
        System.out.println("With recursion:");
        printTriangle(4);
        System.out.println("With recursion and StringBuilder:");
        printTriangleWithStringBuilder(4);
        System.out.println("With recursion and String.repeat:");
        printTriangleWithRepeat(4);
        System.out.println("Without recursion:");
        printTriangleLoopsOnly(4);
    }
}
