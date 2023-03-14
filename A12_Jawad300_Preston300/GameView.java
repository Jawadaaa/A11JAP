import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameView {
    private JFrame frame;
    private JPanel panel;
    private JButton startButton;
    private JLabel scoreLabel;
    private JLabel statusLabel;

    public GameView() {
        frame = new JFrame("My Game");
        panel = new JPanel();
        startButton = new JButton("Start");
        scoreLabel = new JLabel("Score: 0");
        statusLabel = new JLabel("Press Start to begin");

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("Game in progress...");
            }
        });

        panel.setLayout(new BorderLayout());
        panel.add(startButton, BorderLayout.CENTER);
        panel.add(scoreLabel, BorderLayout.WEST);
        panel.add(statusLabel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }

    public void showSplashScreen() {
        // show splash screen here
        JOptionPane.showMessageDialog(frame, "Welcome to My Game!");
    }

    public void showAboutDialog() {
        // show about dialog here
        JOptionPane.showMessageDialog(frame, "My Game version 1.0\nCreated by John Doe");
    }

    public void showColorChooserDialog() {
        // show color chooser dialog here
        Color newColor = JColorChooser.showDialog(frame, "Choose a color", Color.WHITE);
        if (newColor != null) {
            // do something with the new color
        }
    }

    public void updateScore(int newScore) {
        scoreLabel.setText("Score: " + newScore);
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public void show() {
        frame.setVisible(true);
    }
}
