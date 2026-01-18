package pij.day11solutions.electronicDevices;

public abstract class MusicPlayer extends ElectronicDevice {
    private double maxHertz;

    public MusicPlayer(double voltage, double maxHertz) {
        super(voltage);
        this.maxHertz = maxHertz;
    }

    public double getMaxHertz() {
        return maxHertz;
    }
}
