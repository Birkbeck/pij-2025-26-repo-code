package pij.day11solutions.railway;

public class ElectricLocomotive extends Locomotive {

    private double volts;

    public ElectricLocomotive(double gaugeMM, double kW, double volts) {
        super(gaugeMM, kW);
        this.volts = volts;
    }

    public double getVolts() {
        return volts;
    }
}
