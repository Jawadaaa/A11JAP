import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

public class A22 extends JFrame {

    class ColorLabelMouseListener extends MouseAdapter {
        private final JLabel colorLabel;
    
        public ColorLabelMouseListener(JLabel colorLabel) {
            this.colorLabel = colorLabel;
        }
    
        @Override
        public void mouseClicked(MouseEvent e) {
            // Display a JColorChooser dialog to allow the user to select a new color
            Color newColor = JColorChooser.showDialog(null, "Choose a color", colorLabel.getBackground());
            if (newColor != null) {
                colorLabel.setBackground(newColor);
            }
        }
    }
  
    private boolean[][] markedSquares;

    public A22() {
        setTitle("Picross");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        Color correctColor = Color.GREEN;
        Color markedColor = Color.YELLOW;
        Color errorColor = Color.RED;
        


        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenu helpMenu = new JMenu("Help");

        // Create game menu items and add to menu
        JMenuItem newGameMenuItem = new JMenuItem("New");
        JMenuItem solutionMenuItem = new JMenuItem("Solution");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the image
                for (Window window : Window.getWindows()) {
                    window.setVisible(false);
                }
                ImageIcon icon = new ImageIcon("exit.png");
                JLabel label = new JLabel(icon);
                JFrame splashFrame = new JFrame();
                splashFrame.setUndecorated(true);
                splashFrame.getContentPane().add(label);
                splashFrame.pack();
                splashFrame.setLocationRelativeTo(null);
                splashFrame.setVisible(true);
        
                // Close the application after 3 seconds
                Timer timer = new Timer(3000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        splashFrame.dispose();
                        System.exit(0);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }
        });
        



        gameMenu.add(newGameMenuItem);
        gameMenu.add(solutionMenuItem);
        gameMenu.addSeparator();
        gameMenu.add(exitMenuItem);

        // Create help menu items and add to menu
        JMenuItem colorsMenuItem = new JMenuItem("Colors");
        JMenuItem solutionHelpMenuItem = new JMenuItem("About");
        helpMenu.add(colorsMenuItem);
        helpMenu.add(solutionHelpMenuItem);
        solutionHelpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame with a title
                JFrame aboutFrame = new JFrame("About Picross");
                
                // Create a JTextArea to display the description
                JTextArea description = new JTextArea();
                description.setEditable(false);
                description.setLineWrap(true);
                description.setWrapStyleWord(true);
                description.setText("Picross are picture logic puzzles in which cells in a grid have to be colored or left blank according to numbers given at the side of the grid to reveal a hidden picture. In this puzzle type, the numbers measure how many unbroken lines of filled-in squares there are in any given row or column. For example, a clue of '4 8 3' would mean there are sets of four, eight, and three filled squares, in that order, with at least one blank square between successive groups.");
                
                // Add the JTextArea to the JFrame and display it
                aboutFrame.getContentPane().add(description);
                aboutFrame.setSize(250, 250);
                aboutFrame.setLocationRelativeTo(null);
                aboutFrame.setVisible(true);
            }
        });
        
        JLabel markedLabel = new JLabel("Marked", JLabel.CENTER);

        colorsMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a new JFrame with a title
                JFrame colorsFrame = new JFrame("Colors");
        
                // Create JLabels for each color with swatches and labels
                JLabel correctLabel = new JLabel("Correct", JLabel.CENTER);
                correctLabel.setForeground(Color.WHITE);
                correctLabel.setOpaque(true);
                correctLabel.setBackground(correctColor);
                correctLabel.addMouseListener(new ColorLabelMouseListener(correctLabel));
        
                markedLabel.setForeground(Color.BLACK);
                markedLabel.setOpaque(true);
                markedLabel.setBackground(markedColor);
                markedLabel.addMouseListener(new ColorLabelMouseListener(markedLabel));
        
                JLabel errorLabel = new JLabel("Error", JLabel.CENTER);
                errorLabel.setForeground(Color.WHITE);
                errorLabel.setOpaque(true);
                errorLabel.setBackground(errorColor);
                errorLabel.addMouseListener(new ColorLabelMouseListener(errorLabel));
        
                // Create a JPanel to hold the JLabels
                JPanel colorsPanel = new JPanel(new GridLayout(3, 1));
                colorsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                colorsPanel.add(correctLabel);
                colorsPanel.add(markedLabel);
                colorsPanel.add(errorLabel);
        
                // Add the JPanel to the JFrame and display it
                colorsFrame.getContentPane().add(colorsPanel);
                colorsFrame.setSize(250, 250);
                colorsFrame.setLocationRelativeTo(null);
                colorsFrame.setVisible(true);
            }
        });
        
  

        
        
        // Add menus to menu bar
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);







        // Create and configure panels
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
        JPanel innerRightPanel = new JPanel();

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 5));
        markedSquares = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(77, 65));
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the row and column of the clicked button
                        int row = -1, col = -1;
                        for (int i = 0; i < 5; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (button == centerPanel.getComponent(i*5+j)) {
                                    row = i;
                                    col = j;
                                    break;
                                }
                            }
                            if (row != -1) {
                                break;
                            }
                        }
                        if (row != -1 && col != -1) {
                            // Update the text in the innerRightPanel
                            String text = "Clicked " + row + "," + col;
                            innerRightPanel.add(new JLabel(text)); // add new label with updated text
                            innerRightPanel.revalidate(); // revalidate the panel to update the layout
                            innerRightPanel.repaint(); // repaint the panel to update the graphics
                        }
                        if (markCheckbox.isSelected()) { // check if mark panel is active and checked
                            
                            markedSquares[row][col] = !markedSquares[row][col];
                            if (markedSquares[row][col]) {
                                button.setBackground(markedLabel.getBackground());
                            } else {
                                button.setBackground(null);
                            }
                        }
                    }
                });
                
                
                centerPanel.add(button);
            }
        }

        
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.ORANGE);
        rightPanel.setPreferredSize(new Dimension(312, 329));

        innerRightPanel.setBackground(Color.RED);
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
        // Create and show splash screen
        ImageIcon icon = new ImageIcon("image.png");
        JLabel label = new JLabel(icon);
        JWindow window = new JWindow();
        window.getContentPane().add(label, BorderLayout.CENTER);
        window.setBounds(500, 150, 300, 300);
        window.setVisible(true);
        
        // Wait for 3 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close the splash screen and show the game
        window.setVisible(false);
        window.dispose();
        new A22();
    }

} 