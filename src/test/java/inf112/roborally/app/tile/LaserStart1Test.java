package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LaserStart1Test {

    private LaserStart1 l = new LaserStart1(0);

    @Test
    public void getRenderPriority() {
        assertEquals(2, l.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        assertEquals('C', l.getSymbol());
    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,0), 5);
        l.execute(p);
        assertEquals(6, p.getDamage());
    }

}