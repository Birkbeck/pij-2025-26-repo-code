package pij.day11solutions.electronicDevices;

public class MP3Player extends MusicPlayer implements DataStorage {

    private double displayArea;

    public MP3Player(double voltage, double maxHertz, double displayArea) {
        super(voltage, maxHertz);
        this.displayArea = displayArea;
    }

    @Override
    public long getFreeBytes() {
        return 0; // TODO replace method stub
    }
}
