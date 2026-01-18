package pij.day11solutions.electronicDevices;

public class DigitalCamera extends ElectronicDevice implements DataStorage {

    private int pixels;

    public DigitalCamera(double voltage, int pixels) {
        super(voltage);
        this.pixels = pixels;
    }

    public int getPixels() {
        return pixels;
    }

    @Override
    public long getFreeBytes() {
        return 0; // TODO replace method stub
    }
}
