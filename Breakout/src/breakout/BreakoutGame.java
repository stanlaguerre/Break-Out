package breakout;
import edu.macalester.graphics.CanvasWindow;

/**
 * The game of Breakout.
 */
public class BreakoutGame {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private breakout.BrickManager grid;
    private breakout.BrickManager brickManager;
    private CanvasWindow canvas;
    private breakout.Paddle paddle;
    private breakout.Ball ball;
    private int life = 3;
    private static int bricksLeft = 100;

    /**
     * Lets the user move the paddle with a mouse. Also makes the ball move, checks
     * for different
     * elements the call collided with, and checks win/lose conditions.
     */
    public BreakoutGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        brickManager = new breakout.BrickManager(canvas);
        canvas.onMouseMove(event -> paddle.setX(event.getPosition().getX()));
        canvas.animate(event -> {
            ball.hitPaddle(canvas, paddle);
            ball.hitBrick(canvas, brickManager);
            ball.move(1);

            if (ball.topCollision() || ball.sideCollision()) {
                ball.move(1);
            }

            if (loseGame() || winGame()) {
                canvas.closeWindow();
            }
        });
    }

    /**
     * Constructs a 10 by 10 grid of bricks.
     */
    public void createGrid() {
        grid = new breakout.BrickManager(canvas);
        grid.generateBrickGrid();
    }

    /**
     * Constructs a paddle at (200,500).
     */
    public void createPaddle() {
        paddle = new breakout.Paddle(200, 500);
        canvas.add(paddle);
    }

    /**
     * Constructs a ball at (250, 300).
     */
    public void createBall() {
        ball = new breakout.Ball(300, 10, 250, 300, canvas);
    }

    /**
     * Adds 100 bricks, a paddle, and ball to the canvas.
     */
    public void run() {
        createPaddle();
        createGrid();
        createBall();
    }

    /**
     * Checks to see if the user won the game. The user wins if they hit all the
     * bricks on the canvas.
     * 
     * @return true if the bricksLeft variable becomes 0. The bricksLeft variable
     *         needs to be manually
     *         changed if the total number of bricks on the canvas is not 100.
     */
    public boolean winGame() {
        if (bricksLeft <= 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks to see if the user lost the game. The user loses the game if the ball
     * touches the bottom
     * of the canvas 3 times.
     * 
     * @return true if the life variable becomes 0. The bricksLeft variable needs to
     *         be manually
     *         changed if the user wants more or less than 3 lives.
     */
    public boolean loseGame() {
        if (ball.Reset()) {
            ball.removeFromCanvas(canvas);
            createBall();
            life -= 1;
        }

        if (life < 1) {
            return true;
        }
        return false;
    }

    public static void destroyBrick() {
        bricksLeft -= 1;
    }

    public static void main(String[] args) {
        BreakoutGame game = new BreakoutGame();
        game.run();
    }
}
