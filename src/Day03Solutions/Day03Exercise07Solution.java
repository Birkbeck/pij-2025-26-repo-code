public class Day03Exercise07Solution {
    public static boolean isReverseOf(int[] xs, int[] ys) {
        if (xs == null) {
            // if xs is null, then also ys must be null for an answer true
            return ys == null;
        }
        // here we know that xs is not null
        if (ys == null) {
            return false;
        }
        // here we know that neither xs nor ys are null
        if (xs.length != ys.length) {
            // for the answer true, the lengths must be the same
            return false;
        }
        // here we know that neither xs nor ys are null,
        // and xs.length is the same as ys.length

        for (int i = 0; i < ys.length; i++) {
            if (xs[i] != ys[ys.length - 1 - i]) {
                return false;
            }
        }
        // here we know that neither xs nor ys are null,
        // and xs.length is the same as ys.length,
        // and for all i from 0 to xs.length - 1, we have
        //   xs[xs.length - 1 - i] == ys[i]

        // ... in other words, ys is the reverse of xs
        return true;
    }

    public static int[] reverse(int[] xs) {
        if (xs == null) {
            return null;
        }
        int[] result = new int[xs.length];
        for (int i = 0; i < xs.length; i++) {
            result[result.length - 1 - i] = xs[i];
        }
        return result;
    }

    public static void reverseInPlace(int[] xs) {
        if (xs == null) {
            return; // nothing to do
        }
        // [1,2,3,4] becomes [4,3,2,1]
        //   => swap xs[0] and xs[3], swap xs[1] and xs[2]
        // [1,2,3] becomes [3,2,1]
        //   => swap xs[0] and xs[2]
        // idea: swap xs[0] and xs[xs.length - 1],
        // then swap xs[1] and  xs[xs.length - 2],
        // then ...
        // then xs[xs.length/2 - 1] and xs[xs.length - (xs.length/2 - 1)]
        for (int i = 0; i < xs.length/2; i++) {
            // swap with a temporary helper variable
            int temp = xs[i];
            xs[i] = xs[xs.length - 1 - i];
            xs[xs.length - 1 - i] = temp;
        }
    }

}
