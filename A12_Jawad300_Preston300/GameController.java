import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class GameController {
    private int[][] grid;
    private int[][] solution;
    private boolean[][] markedSquares;
    private Color correctColor = Color.GREEN;
    private Color markedColor = Color.YELLOW;
    private Color errorColor = Color.RED;
    private Timer timer;
    private long startTime;

    public GameController(int[][] grid, int[][] solution) {
        this.grid = grid;
        this.solution = solution;
        this.markedSquares = new boolean[grid.length][grid[0].length];
        this.timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsed = (System.currentTimeMillis() - startTime) / 1000;
                System.out.println("Time elapsed: " + elapsed + " seconds");
            }
        });
    }

    public void startGame() {
        startTime = System.currentTimeMillis();
        timer.start();
        // TODO: Implement the game UI
    }

    public void markSquare(int row, int col) {
        markedSquares[row][col] = true;
        // TODO: Update the UI to reflect the marking of the square
    }

    public void unmarkSquare(int row, int col) {
        markedSquares[row][col] = false;
        // TODO: Update the UI to reflect the unmarking of the square
    }

    public boolean isSquareMarked(int row, int col) {
        return markedSquares[row][col];
    }

    public boolean isPuzzleSolved() {
        return Arrays.deepEquals(grid, solution);
    }

    public Color getCorrectColor() {
        return correctColor;
    }

    public Color getMarkedColor() {
        return markedColor;
    }

    public Color getErrorColor() {
        return errorColor;
    }

    public void setCorrectColor(Color color) {
        correctColor = color;
        // TODO: Update the UI to reflect the new correct color
    }

    public void setMarkedColor(Color color) {
        markedColor = color;
        // TODO: Update the UI to reflect the new marked color
    }

    public void setErrorColor(Color color) {
        errorColor = color;
        // TODO: Update the UI to reflect the new error color
    }
}
