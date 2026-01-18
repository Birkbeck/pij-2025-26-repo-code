package pij.day11solutions.electronicDevices;

// class is abstract: for a concrete instance ElectronicDevice,
// we would need more information
public abstract class ElectronicDevice {
    private double voltage;

    public ElectronicDevice(double voltage) {
        this.voltage = voltage;
    }

    public double getVoltage() {
        return voltage;
    }
}
