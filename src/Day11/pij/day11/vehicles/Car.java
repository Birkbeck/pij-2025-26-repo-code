package pij.day11.vehicles;

public class Car extends MotorVehicle {

    private Tyre leftFrontTyre;
    private Tyre rightFrontTyre;
    private Tyre leftRearTyre;
    private Tyre rightRearTyre;

    // alternative: private List<Tyre> tyres;
    // -> more flexible number of tyres, less clear which tyre is where

    public Car(String ownerName) {
        super(ownerName);
        this.leftFrontTyre = new Tyre();
        this.rightFrontTyre = new Tyre();
        this.leftRearTyre = new Tyre();
        this.rightRearTyre = new Tyre();
    }

    @Override
    public double computeKW() {
        return 0; // TODO Auto-generated method stub
    }
}
