package pij.day19solutions.fibonacci;

import pij.day12.fibonacci.FibonacciTry1;
import pij.day13solutions.fibonacciLoop.FibLoop;
import pij.day15.fibonacci.Fibonacci;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * Day 19, Exercises 4.1 - 4.4.
 * A GUI for computing Fibonacci numbers.
 */
public class FibonacciGUI {

    // some constants to configure the GUI (avoid magic numbers)
    private static final int THE_WINDOW_WIDTH = 800;
    private static final int THE_WINDOW_HEIGHT = 300;
    private static final int THE_COLUMN_WIDTH = 20;
    private static final String[] ALGORITHMS = {
            "recursive direct",
            "recursive with memo",
            "iterative" };

    /**
     * Constructs all the components for our GUI, puts them into
     * a suitably configured JFrame, and makes the JFrame visible.
     */
    public FibonacciGUI() {

        // set up all the components of the GUI
        JLabel instructionLabel = new JLabel("Please enter a positive integer!");
        JLabel outputLabel = new JLabel(); // empty at first
        JLabel timeLabel = new JLabel(); // empty at first
        JTextField inputTextField = new JTextField(THE_COLUMN_WIDTH); // inputs can be longer!
        JList<String> algoList = new JList<>(ALGORITHMS);

        // inputListener will be used twice, so use a variable
        ActionListener inputListener = (ae) -> {
            String input = inputTextField.getText();
            int n;
            try {
                n = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                outputLabel.setText(input + " is not an int!");
                return;
            }
            if (n < 0) {
                outputLabel.setText(input + " is a negative number!");
                return;
            }
            int algoIndex = algoList.getSelectedIndex();
            long result;
            long nanosBefore = System.nanoTime();
            switch (algoIndex) {
                case 0: // recursive, no memoisation
                    FibonacciTry1 fibTry1 = new FibonacciTry1();
                    result = fibTry1.fib(n);
                    break;
                case 1: // recursive with memoisation
                    result = Fibonacci.fib(n);
                    break;
                case 2: // iterative
                    result = FibLoop.fibIterative(n);
                    break;
                default:
                    throw new RuntimeException("Unexpected index!");
            }
            long nanosAfter = System.nanoTime();
            long millisTotal = (nanosAfter - nanosBefore)/1000000;
            String output = "Algorithm " + ALGORITHMS[algoIndex]
                    + " says fib(" + n + ") = " + result;
            outputLabel.setText(output);
            String timeText = "The computation took " + millisTotal + " ms.";
            timeLabel.setText(timeText);
        };
        inputTextField.addActionListener(inputListener);

        JButton button = new JButton("Check!");
        button.addActionListener(inputListener);

        // everything will be shown in a JFrame (it's like a window)
        JFrame jFrame = new JFrame("Fibonacci!");
        jFrame.setLayout(new FlowLayout()); // sensible "default choice"
        jFrame.setSize(THE_WINDOW_WIDTH, THE_WINDOW_HEIGHT); // vary the constants for your needs

        // when the window closes, the program should terminate
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // now put the components into the JFrame in the desired order
        jFrame.add(instructionLabel);
        jFrame.add(algoList);
        jFrame.add(inputTextField);
        jFrame.add(button);
        jFrame.add(outputLabel);
        jFrame.add(timeLabel);

        /* The lines about font size are optional. */
        // retrieve the current font...
        Font oldFont = UIManager.getFont("Label.font");
        // ...and make it twice as large (note the cast to float!)
        Font newFont = oldFont.deriveFont((float) (oldFont.getSize()*2));
        instructionLabel.setFont(newFont);
        algoList.setFont(newFont);
        outputLabel.setFont(newFont);
        timeLabel.setFont(newFont);
        inputTextField.setFont(newFont);
        button.setFont(newFont);

        // actually show the JFrame
        jFrame.setVisible(true);
    }

    /**
     * Runs the Swing GUI for our example.
     */
    public static void main(String[] args) {
        // use a lambda expression for the code to run by the GUI thread
        SwingUtilities.invokeLater(FibonacciGUI::new);
    }
}
