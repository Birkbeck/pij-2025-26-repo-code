package pij.day11solutions.electronicDevices;

public class AlarmClock extends ElectronicDevice{
    private String alarmTime;

    public AlarmClock(double voltage, String alarmTime) {
        super(voltage);
        this.alarmTime = alarmTime;
    }

    public String getAlarmTime() {
        return alarmTime;
    }
}
