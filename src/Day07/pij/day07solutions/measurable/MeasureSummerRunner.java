package pij.day07solutions.measurable;

// Exercise 2:
public class MeasureSummerRunner {

    private void launch() {
        Measurable[] ms = new Measurable[3];
        // Ex 2:
        // We /can/ run method MeasureSummer.sumMeasures(ms) already at this
        // point, without having created any implementations for Measurable.
        // A downside is that all references of type Measurable in ms will
        // necessarily be null. Since calling a method like getMeasure() on
        // the null reference will cause a NullPointerException, this is not
        // going to be the most fruitful endeavour.

        // Ex 4:
        // The next two lines make use of the specific implementations of
        // interface Measurable that we have created in the meantime.
        ms[0] = new Point(3,4);
        ms[1] = new Horse(20);
        ms[2] = new MeasurableString("Hello");
        double d = MeasureSummer.sumMeasures(ms);
        System.out.println(d);
    }

    public static void main(String[] args) {
        MeasureSummerRunner runner = new MeasureSummerRunner();
        runner.launch();
    }
}
