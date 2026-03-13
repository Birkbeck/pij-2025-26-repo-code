package pij.day19solutions.fibonacciMultiThread;

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
 * Day 19, Exercise 4.5.
 * GUI for Fibonacci calculations with different algorithms.
 */
public class FibonacciGUIMT {

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
    public FibonacciGUIMT() {
        // set up all the components of the GUI
        JLabel instructionLabel = new JLabel("Please enter a positive integer!");
        JLabel outputLabel = new JLabel(); // empty at first
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
            FibAlg alg;
            switch (algoIndex) {
                case 0:
                    alg = FibAlg.RECURSIVE_SIMPLE;
                    break;
                case 1:
                    alg = FibAlg.RECURSIVE_MEMO;
                    break;
                case 2:
                    alg = FibAlg.ITERATIVE;
                    break;
                default:
                    throw new IllegalStateException("Unexpected case " + algoIndex);
            }
            // now set up the worker and (for simplicity) start it in a new thread
            FibonacciWorker worker = new FibonacciWorker(n, alg, outputLabel);
            new Thread(worker).start();
        };
        inputTextField.addActionListener(inputListener);

        JButton button = new JButton("Check!");
        button.addActionListener(inputListener);

        // everything will be shown in a JFrame (it's like a window)
        JFrame jFrame = new JFrame("Fibonacci with Multi-Threading");
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

        // retrieve the current font...
        Font oldFont = UIManager.getFont("Label.font");
        // ...and make it twice as large (note the cast to float!)
        Font newFont = oldFont.deriveFont((float) (oldFont.getSize()*2));
        instructionLabel.setFont(newFont);
        algoList.setFont(newFont);
        outputLabel.setFont(newFont);
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
        SwingUtilities.invokeLater(FibonacciGUIMT::new);
    }
}
