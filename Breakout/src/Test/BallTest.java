import breakout.Ball;
import breakout.BreakoutGame;
import org.junit.jupiter.api.Test;


import java.beans.Transient;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallTest {

    @Test
    void gameWinTest() {
        BreakoutGame game = new BreakoutGame();
        for(int i = 0; i < 100; i++)
            game.destroyBrick();
        assertTrue(game.winGame());
    }

    @Test
    void sideCollisionTest(){
        BreakoutGame game = new BreakoutGame();
        game.run();
    }
}


