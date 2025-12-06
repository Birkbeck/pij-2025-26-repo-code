package pij.day10solutions.detective;
public class Day10Exercise02 {

    /**
     * Returns the sum of the lengths of the non-null entries in strings.
     *
     * @param strings must not be null, but may contain null
     * @return the sum of the lengths of the non-null entries in strings
     * @throws NullPointerException if strings is the null reference
     */
    public static int sumLengths(String[] strings) {
        int result = 0;
        for (String s : strings) {
            // ORIGINAL CODE:
            //result += s.length();
            // The JavaDoc of the method says that s is allowed to be null.
            // But calling method s.length() will throw a NullPointerException
            // if s is null. So we must improve our method so that it handles
            // null entries gracefully.

            // ALTERNATIVE 1:
            //if (s == null) { // escape clause: skip this element,
            //    continue;    // continue with the next one
            //}
            //result += s.length();

            // ALTERNATIVE 2:
            if (s != null) {
                result += s.length();
            }
        }
        return result;
    }

    /**
     * Computes and prints the sum of the lengths of the non-null entries in
     * words.
     *
     * @param words must not be null, but may contain null
     * @throws NullPointerException if words is the null reference
     */
    public static void process(String[] words) {
        int sum = sumLengths(words);
        System.out.println("The sum of the lengths is " + sum);
    }

    public static void main(String[] args) {
        String[] myWords = new String[3];
        myWords[0] = "Hello";
        myWords[1] = null; // myWords /contains/ the null reference
        myWords[2] = "World";
        process(myWords);
        System.out.println("Take 2.");

        //String[] noWords = null; // noWords /is/ the null reference
        // The JavaDoc of method process(...) called below with noWords as
        // argument says a NullPointerException should be expected as
        // a reaction of calling the method with the null reference as an
        // argument and that the argument must not be null. So the cause of
        // the NullPointerException is in method main, where we are not
        // using method process(...) according to its specification.
        // The variable name suggests that probably an array of length 0
        // (which has no words) was intended. We repair the code accordingly:

        String[] noWords = new String[0];
        process(noWords);
        System.out.println("Bye!");
    }
}
