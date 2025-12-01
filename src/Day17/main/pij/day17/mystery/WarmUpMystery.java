package pij.day17.mystery;

public class WarmUpMystery {

    private static void helper(boolean aFlag) {
        final int MAX = 20;
        for (int i = 0; i < MAX; i++) {
            System.out.print(aFlag ? "A" : "B");
        }
    }

    public static void main(String[] args) {
        Runnable rA = () -> helper(true);
        Runnable rB = () -> helper(false);
        new Thread(rA).start();
        new Thread(rB).start();
    }
}
