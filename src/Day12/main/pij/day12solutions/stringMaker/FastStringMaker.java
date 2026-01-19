package pij.day12solutions.stringMaker;

public class FastStringMaker {
    public static String build(int max) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
}
