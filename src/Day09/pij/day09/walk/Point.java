package pij.day09.walk;

/**
 * Implementation of the geometrical concept of a point in two dimensions.
 * Provides methods to access the coordinates as well as to move a point.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructs a new {@code Point} with the given coordinates.
     *
     * @param x the x coordinate of the new {@code Point}
     * @param y the y coordinate of the new {@code Point}
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for the x coordinate of this {@code Point}.
     *
     * @return the x coordinate of this {@code Point}
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y coordinate of this {@code Point}.
     *
     * @return the y coordinate of this {@code Point}
     */
    public int getY() {
        return y;
    }

    /**
     * Changes the coordinates of this {@code Point} to be the same as those of
     * remote.
     *
     * @param remote the {@code Point} to which we want to move this {@code Point}
     */
    public void moveTo(Point remote) {
        this.x = remote.x;
        this.y = remote.y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Returns the Euclidean distance from this Point to p. The Euclidean
     * distance from a point (x,y) to a point (x',y') is given by
     * sqrt( (x - x')<sup>2</sup> + (y - y')<sup>2</sup> ).
     *
     * @return the Euclidean distance from this Point to p
     */
    public double distance(Point p) {
        double diffX = x - p.x;
        double diffY = y - p.y;
        return Math.sqrt(diffX*diffX + diffY*diffY);
    }
}
