package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepairFullTest {

    private RepairFull r = new RepairFull(0);

    @Test
    public void getRenderPriority() {
        assertEquals(2, r.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('A', r.getSymbol());

    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 5);
        r.execute(p);
        assertEquals(0, p.getDamage());
    }

}