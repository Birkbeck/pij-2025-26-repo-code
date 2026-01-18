package pij.day11solutions.railway;

public class Locomotive extends RailwayRollingStock {

    private double kW;

    public Locomotive(double gaugeMM, double kW) {
        super(gaugeMM);
        this.kW = kW;
    }

    public double getkW() {
        return kW;
    }
}
