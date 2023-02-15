import static org.junit.jupiter.api.Assertions.*;
import breakout.BreakoutGame;
import org.junit.jupiter.api.Test;
import java.beans.Transient;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BreakoutGameTest {

    @Test
    void loseGame() {
        BreakoutGame game = new BreakoutGame();
        game.life -= 2;
        assertFalse(game.loseGame());
        game.life -= 1;
        assertTrue(game.loseGame());
    }
}