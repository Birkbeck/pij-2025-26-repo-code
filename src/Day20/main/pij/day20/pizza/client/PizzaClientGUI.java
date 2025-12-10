package pij.day20.pizza.client;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple GUI for a pizza ordering client. The PizzaClientGUI class provides
 * a graphical interface to place pizza orders. It allows users to select a
 * customer name, pizza type, and size, and then to place an order.
 * The GUI updates with the response from the server after placing an order.
 */
public class PizzaClientGUI {

    public static final int GRID_PANEL_ROWS = 4;
    public static final int GRID_PANEL_COLS = 2;
    public static final int HORIZONTAL_GAP = 5;
    public static final int VERTICAL_GAP = 5;
    public static final int APP_WIDTH = 400;
    public static final int APP_HEIGHT = 300;

    private final PizzaClient pizzaClient;
    private final JFrame appFrame;
    private final JTextField customerField;
    private final JComboBox<String> pizzaBox;
    private final JComboBox<String> sizeBox;
    private final JTextArea outputArea;

    /**
     * Constructs the GUI components, sets up the layout, and initializes the application frame.
     * It includes input fields for customer name, pizza type, and size, as well as an output area
     * to display the server response after placing an order.
     *
     * This constructor could be refactored to make reading and understanding the code easier.
     * For example, we could extract the input panel creation into a separate method.
     */
    public PizzaClientGUI() {
        // does the actual work behind the scenes
        pizzaClient = new PizzaClient();

        // now set up the GUI to make the pizza client's services available
        // to the end user
        appFrame = new JFrame();
        appFrame.setTitle("Pizza Ordering Client");
        appFrame.setSize(APP_WIDTH, APP_HEIGHT);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setLayout(new BorderLayout());

        // Top Panel – Input fields
        JPanel inputPanel = new JPanel(new GridLayout(GRID_PANEL_ROWS, GRID_PANEL_COLS, HORIZONTAL_GAP, VERTICAL_GAP));

        inputPanel.add(new JLabel("Customer Name:"));
        customerField = new JTextField();
        inputPanel.add(customerField);

        // Pizza type selection requires a network call to get available pizzas, we create a separate method for it.
        pizzaBox = getPizzaJComboBox(inputPanel);

        inputPanel.add(new JLabel("Size:"));
        sizeBox = new JComboBox<>(new String[]{"Small", "Medium", "Large"});
        inputPanel.add(sizeBox);

        JButton orderButton = new JButton("Place Order");
        inputPanel.add(orderButton);

        appFrame.add(inputPanel, BorderLayout.NORTH);

        // Output panel
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        appFrame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Button action
        orderButton.addActionListener(e -> placeOrder());

        appFrame.setVisible(true);
    }

    /**
     * Creates a JComboBox for selecting pizza types, populating it with available pizzas from the server.
     * If the server is not available, it will display an error message to the console vir System.err.
     *
     * @param inputPanel The panel to which the JComboBox will be added.
     * @return A JComboBox containing available pizza types.
     */
    private JComboBox<String> getPizzaJComboBox(JPanel inputPanel) {
        final JComboBox<String> pizzaBox;
        List<String> pizzaTypes = new ArrayList<>();
        inputPanel.add(new JLabel("Pizza Type:"));
        try {
            pizzaTypes = pizzaClient.getAvailablePizzas();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        String[] pizzaTypesArray = pizzaTypes.toArray(new String[0]);

        pizzaBox = new JComboBox<>(pizzaTypesArray);
        inputPanel.add(pizzaBox);
        return pizzaBox;
    }

    /**
     * Places an order by sending the customer name, selected pizza type, and size to the server.
     * It handles input validation and displays the server response in the output area.
     * If the server is not available or an error occurs, it shows an error message.
     */
    private void placeOrder() {
        String customer = customerField.getText().trim();
        // pizzaBox.getSelectedItem() would be the more obvious choice, but
        // returns only an Object reference rather than a String reference
        String pizza = pizzaBox.getItemAt(pizzaBox.getSelectedIndex());
        String size = sizeBox.getItemAt(pizzaBox.getSelectedIndex());

        //if pizza is null or empty, it means the server is not available or no pizzas were returned.
        // We can show an error message to the user.
        if (pizza == null || pizza.isEmpty()) {
            JOptionPane.showMessageDialog(appFrame, "Pizza Server is not available, please try again later.");
            return;
        }

        // Validate customer input
        if (customer.isEmpty()) {
            JOptionPane.showMessageDialog(appFrame, "Please enter customer name.");
            return;
        }

        // Run network request in separate thread to avoid UI freeze.
        // Another reason why we separate the GUI from the network code:
        // network requests can take time, and we don't want to block the
        // GUI thread.
        // Alternative: use an executor object
        new Thread(() -> {
            try {
                String response = pizzaClient.sendOrder(customer, pizza, size);
                SwingUtilities.invokeLater(() -> outputArea.setText(response));
            }
            catch (IOException ex) {
                SwingUtilities.invokeLater(() ->
                        outputArea.setText("Error: " + ex.getMessage())
                );
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PizzaClientGUI::new);
    }
}
