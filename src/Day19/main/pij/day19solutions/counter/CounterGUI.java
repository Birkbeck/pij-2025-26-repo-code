package pij.day19solutions.counter;

import pij.day17.increaser.Counter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;

/**
 * Day 19, Exercise 2.
 * This class provides a GUI for a counter, allowing a user to count a manually
 * entered number of events.
 */
public class CounterGUI {
    private static final int WINDOW_WIDTH = 360;
    private static final int WINDOW_HEIGHT = 270;

    public CounterGUI() {
        Counter counter = new Counter();

        JFrame jFrame = new JFrame("Count up");
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        jFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel outputLabel = new JLabel("" + counter.getCount());
        JButton button = new JButton("Add one!");
        button.addActionListener((ae) -> {
            counter.increase();
            outputLabel.setText("" + counter.getCount());
        });

        // now put the components into the JFrame in the desired order
        jFrame.add(button);
        jFrame.add(outputLabel);
        jFrame.setVisible(true);
    }

    /**
     * Runs the Swing GUI for our example.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(CounterGUI::new);
    }
}
