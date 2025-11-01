package pij.day09.walk;

/**
 * Runner class for Walk.
 */
public class WalkRunner {
    public static void main(String[] args) {
        Walk walk = new Walk();
        walk.extend(new Point(0, 0)); // walk length 0.0
        walk.extend(new Point(3, 4)); // + 5.0
        walk.extend(new Point(8, 16)); // + 13.0
        walk.extend(new Point(16, 31)); // + 17.0
        walk.extend(new Point(9, 7)); // + 25.0
        System.out.println(walk);
        System.out.println(walk.length()); // 60.0
    }
}
