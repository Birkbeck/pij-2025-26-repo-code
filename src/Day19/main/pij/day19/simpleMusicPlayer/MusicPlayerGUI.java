package pij.day19.simpleMusicPlayer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

/**
 * Exercise 2.
 * A simple GUI for a music player with play, back, and next buttons.
 * The MusicPlayerGUI class provides a graphical interface to control the
 * MusicPlayer functionality.
 *
 *  Part 1 of the question requires implementing action listeners for the
 *  play and next buttons. The play button should toggle between play and
 *  stop states, changing its text accordingly.
 *
 *  Part 2 of the question involves enhancing the GUI with additional
 *  feature of displaying the current track name when a track is played,
 *  stopped, or changed. This may involve adding a JLabel to show track
 *  information and using appropriate layout managers for better component
 *  arrangement.
 */
public class MusicPlayerGUI {

    // Constants for GUI configuration
    public static final int BUTTON_WIDTH = 80;
    public static final int BUTTON_HEIGHT = 40;
    public static final Color BUTTON_BACKGROUND_COLOR = new Color(70, 130, 180);
    public static final Color BUTTON_FOREGROUND_COLOR = Color.WHITE;
    public static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 14);
    public static final int FRAME_WIDTH = 350;
    public static final int FRAME_HEIGHT = 120;
    public static final String BUTTON_BACK_TEXT = "Back";
    public static final String BUTTON_NEXT_TEXT = "Next";
    public static final String BUTTON_PLAY_TEXT = "Play";

    private JButton playButton;
    private JButton backButton;
    private JButton nextButton;

    public MusicPlayerGUI() {
        MusicPlayer musicPlayer = new MusicPlayer();
        JFrame jFrame = new JFrame("Simple Music Player");
        jFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Put the GUI into the centre of the screen
        jFrame.setLocationRelativeTo(null);

        // Create buttons
        createButtons();

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(backButton);
        panel.add(playButton);
        panel.add(nextButton);

        jFrame.add(panel);

        // Add listeners
        backButton.addActionListener(e -> musicPlayer.backward());

        // TODO - add action listeners for playButton and nextButton.
        // The playButton should toggle between play and stop states
        // changing its text accordingly.


        // Display JFrame on the screen
        jFrame.setVisible(true);
    }

    /**
     * Creates and configures the buttons to control the music player.
     */
    private void createButtons() {
        backButton = new JButton(BUTTON_BACK_TEXT);
        playButton = new JButton(BUTTON_PLAY_TEXT);
        nextButton = new JButton(BUTTON_NEXT_TEXT);

        // create a list of buttons to apply common configurations
        List<JButton> buttonList = List.of(backButton, playButton, nextButton);

        for (JButton button : buttonList) {
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
            button.setFocusPainted(false);
            button.setBackground(BUTTON_BACKGROUND_COLOR);
            button.setForeground(BUTTON_FOREGROUND_COLOR);
            button.setFont(BUTTON_FONT);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MusicPlayerGUI::new);
    }
}
