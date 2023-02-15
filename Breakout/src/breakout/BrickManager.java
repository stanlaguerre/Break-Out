package breakout;

import edu.macalester.graphics.CanvasWindow;
import java.awt.Color;

public class BrickManager {
    private CanvasWindow canvas;

    /**
     * Constructs a brick manager for the specified window object.
     */
    public BrickManager(CanvasWindow canvas) {
        this.canvas = canvas;
    }

    /**
     * Constructs 2 rows and 10 columns of bricks of the same color.
     * @param initialY the starting y coordinate for each row of bricks.
     */
    public void generateBrickRow(Color color, double initialY) {
        double initialX = 11;
        for (int n = 0; n < 2; n++) {
            for (int i = 0; i < 10; i++) {
                Brick brick = new Brick(initialX, initialY, color);
                canvas.add(brick);
                initialX += 59;
            }
            initialX = 11;
            initialY += 19;
        }
    }
    
    /**
     * Constructs 10 row and 10 columns of bricks. Every pair of rows is a different color from
     * other pair of rows. 
     */
    public void generateBrickGrid() {
        generateBrickRow(Color.RED, 50);
        generateBrickRow(Color.ORANGE, 90);
        generateBrickRow(Color.YELLOW, 130);
        generateBrickRow(Color.GREEN, 170);
        generateBrickRow(Color.BLUE, 210);
    }
}
