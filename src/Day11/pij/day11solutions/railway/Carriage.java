package pij.day11solutions.railway;

public class Carriage extends RailwayRollingStock {

    private int numberOfSeats;

    public Carriage(double gaugeMM, int numberOfSeats) {
        super(gaugeMM);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
