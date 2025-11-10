package pij.day11.vehicles;

public interface HasFarePassengers extends HasPassengers {
    double computeFare(String destination);
}
