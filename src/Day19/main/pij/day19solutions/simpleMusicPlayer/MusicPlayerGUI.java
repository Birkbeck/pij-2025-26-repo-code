package pij.day19solutions.simpleMusicPlayer;

// We can use the MusicPlayer class "as is", so we can import it rather than
// make a copy.
import pij.day19.simpleMusicPlayer.MusicPlayer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.List;

/**
 * Day 19, Exercise 3.
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
    public static final String BUTTON_STOP_TEXT = "Stop";
    public static final String TRACK_NONE = "<nothing>";

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
        JPanel buttonPanel = new JPanel(); // Ex 3b. renamed for clarity
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(backButton);
        buttonPanel.add(playButton);
        buttonPanel.add(nextButton);

        // Exercise 3b. Add a line for the track information
        JLabel trackLabel = new JLabel(TRACK_NONE);
        trackLabel.setForeground(BUTTON_BACKGROUND_COLOR);

        // Holds the track info and the panel for the buttons
        JPanel trackAndButtonPanel = new JPanel();
        trackAndButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        trackAndButtonPanel.add(trackLabel);

        // Put the button panel into the larger panel
        trackAndButtonPanel.add(buttonPanel);
        jFrame.add(trackAndButtonPanel);

        // Add listeners
        backButton.addActionListener(e -> {
            musicPlayer.backward();
            trackLabel.setText(musicPlayer.getSongTitle()); // Ex 3b
        });

        // Exercise 3a.
        // The playButton should toggle between play and stop states
        // changing its text accordingly.
        playButton.addActionListener(e -> {
            if (musicPlayer.isPlaying()) {
                playButton.setText(BUTTON_PLAY_TEXT); // Ex 3a
                trackLabel.setText(TRACK_NONE); // Ex 3b
                musicPlayer.stop(); // Ex 3a
            } else {
                playButton.setText(BUTTON_STOP_TEXT); // Ex 3a
                trackLabel.setText(musicPlayer.getSongTitle()); // Ex 3b
                musicPlayer.play(); // Ex 3a
            }
        });

        nextButton.addActionListener(e -> {
            musicPlayer.forward(); // Ex 3a
            trackLabel.setText(musicPlayer.getSongTitle()); // Ex 3b
        });

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
