package pij.day11solutions.railway;

public class SteamLocomotive extends Locomotive {

    private double maxPressurePascal;

    public SteamLocomotive(double gaugeMM, double kW, double maxPressurePascal) {
        super(gaugeMM, kW);
        this.maxPressurePascal = maxPressurePascal;
    }

    public double getMaxPressurePascal() {
        return maxPressurePascal;
    }
}
