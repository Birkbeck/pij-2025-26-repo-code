package pij.day07solutions.measurable;

// Ex 6
public class MeasurableString implements Measurable {

    private final String data;

    public MeasurableString(String data) {
        this.data = data;
    }

    @Override
    public double getMeasure() {
        return data.length();
    }
}
