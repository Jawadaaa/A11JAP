import javax.swing.*;
import java.awt.*;

public class A12UI extends JFrame {

    public A12UI() {

        
        setTitle("Picross");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel markPanel = new JPanel();
        markPanel.setBackground(Color.RED);
        markPanel.setPreferredSize(new Dimension(145, 78));

        JCheckBox markCheckbox = new JCheckBox("Mark");
        markPanel.add(markCheckbox);
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.DARK_GRAY);
        topPanel.setPreferredSize(new Dimension(385, 78));
        topPanel.setLayout(new GridLayout(1, 5));
        for (int i = 0; i < 5; i++) {
            JLabel label = new JLabel("(" + (i + 1) + ")");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setForeground(Color.WHITE);

            topPanel.add(label);
        }

        JPanel trPanel = new JPanel();
        trPanel.setBackground(Color.RED);
        trPanel.setPreferredSize(new Dimension(312, 78));

        JLabel label = new JLabel("PICROSS");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setForeground(Color.WHITE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        trPanel.add(label);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(markPanel, BorderLayout.WEST);
        northPanel.add(topPanel, BorderLayout.CENTER);
        northPanel.add(trPanel, BorderLayout.EAST);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.DARK_GRAY);
        leftPanel.setPreferredSize(new Dimension(149, 329));
        leftPanel.setLayout(new GridLayout(5, 1));
        for (int i = 0; i < 5; i++) {
            JLabel lLabel = new JLabel("(" + (i + 1) + ")");
            lLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lLabel.setForeground(Color.WHITE);

            leftPanel.add(lLabel);
        }

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 5));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(77, 65));
                centerPanel.add(button);
            }
        }
        //add langauges

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.ORANGE);
        rightPanel.setPreferredSize(new Dimension(312, 329));

        JPanel innerRightPanel = new JPanel();
        innerRightPanel.setBackground(Color.GRAY);
        innerRightPanel.setPreferredSize(new Dimension(218, 235));
        rightPanel.add(innerRightPanel, BorderLayout.CENTER);

        JPanel controPanel = new JPanel();
        controPanel.setLayout(new FlowLayout());
        JLabel controLabel = new JLabel("Control Panel");
        controPanel.add(controLabel);
        rightPanel.add(controPanel, BorderLayout.NORTH);
        JPanel bottomRightPanel = new JPanel();
        bottomRightPanel.setLayout(new FlowLayout());
        JLabel restartLabel = new JLabel("Restart");
        JLabel timeLabel = new JLabel("Time: 0s");
        JLabel newGameLabel = new JLabel("New Game");

        bottomRightPanel.add(restartLabel);
        bottomRightPanel.add(timeLabel);
        bottomRightPanel.add(newGameLabel);
        rightPanel.add(bottomRightPanel, BorderLayout.SOUTH);

        JPanel pointsPanel = new JPanel();
        pointsPanel.setLayout(new FlowLayout());
        JLabel pointsLabel = new JLabel("Points: 0");
        pointsPanel.add(pointsLabel);
        rightPanel.add(pointsPanel, BorderLayout.SOUTH);

        add(northPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new A12UI();
    }

}