public class DoublePoint {
    private double x;
    private double y;

    public DoublePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public DoublePoint(DoublePoint dp) {
        this(dp.x, dp.y); // reuse existing constructor: DRY
    }

    public double distanceTo(DoublePoint dp) {
        // the distance from (x,y) to (x',y') is
        // sqrt( (x-x')*(x-x') + (y-y')*(y-y') )

        // compute the differences just once
        double xDiff = this.x - dp.x;
        double yDiff = this.y - dp.y;

        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }

    public double distanceToOrigin() {
        // OPTION 1:
        //return Math.sqrt(this.x*this.x + this.y*this.y);
        // OPTION 2:
        return distanceTo(new DoublePoint(0, 0));
    }

    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(DoublePoint dp) {
        moveTo(dp.x, dp.y);
    }

    public DoublePoint copy() {
        // writing
        //return this;
        // would return this object itself; we want a fresh copy
        return new DoublePoint(this);
    }

    public DoublePoint opposite() {
        return new DoublePoint(- this.x, - this.y);
    }

    // was NOT required for this exercise, but is useful for testing
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}
