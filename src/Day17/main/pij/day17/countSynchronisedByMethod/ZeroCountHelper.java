package pij.day17.countSynchronisedByMethod;

public class ZeroCountHelper {
    public static void countOne(ZeroCount zc, String prefix) {
        int count = zc.getCount();
        if (count != 0) { // report only "unexpected" values
            System.out.println(prefix + " thread says: " + count);
        }
    }

    public static void countMany(ZeroCount zc, String prefix) {
        final int LIMIT = 1000; // increase value if needed
        for (int i = 0; i < LIMIT; i++) {
            countOne(zc, prefix);
        }
    }
}
