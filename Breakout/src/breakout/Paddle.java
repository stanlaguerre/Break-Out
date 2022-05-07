package breakout;

import java.awt.Color;

import edu.macalester.graphics.Rectangle;

public class Paddle extends Rectangle {
    /**
     * Constructs a paddle where its top left corner is at (centerX,centerY).
     * @param centerX
     * @param centerY
     */
    public Paddle(double centerX, double centerY) {
        super(centerX, centerY, 150, 2);
        setStrokeColor(Color.BLACK);
        setStrokeWidth(5);
    }

    /**
     * Returns the center y coordinate of the paddle.
     */
    public double getCenterY(){
        return getCenter().getY();
    }

}
