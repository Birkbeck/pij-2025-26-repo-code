package pij.day11solutions.railway;

public abstract class RailwayRollingStock {

    private double gaugeMM;

    public RailwayRollingStock(double gaugeMM) {
        this.gaugeMM = gaugeMM;
    }

    public double getGaugeMM() {
        return gaugeMM;
    }
}
