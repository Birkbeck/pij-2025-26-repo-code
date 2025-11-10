package pij.day11.vehicles;

public abstract class MotorVehicle extends Vehicle {
    public MotorVehicle(String ownerName) {
        super(ownerName);
    }

    public abstract double computeKW();
}
