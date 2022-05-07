package breakout;

import edu.macalester.graphics.Rectangle;

import java.awt.Color;

public class Brick extends Rectangle {
    
    /**
     * Constructs a brick where its top left corner is at (coordX,coordY).
     * @param coordX
     * @param coordY
     * @param color
     */
    public Brick(double coordX, double coordY, Color color) {
        super(coordX, coordY, 49, 10);
        createBrickDrawing(color);
    }

    /**
     * Creates a rectangle to represent a brick.
     */
    private void createBrickDrawing(Color color) {
        setFillColor(color);
        setFilled(true);
    }

}
