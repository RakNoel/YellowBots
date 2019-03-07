package inf112.roborally.app.tile;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class BarricadeTest {

    private Barricade b = new Barricade(90);

    @Test
    public void getRenderPriority() {
        Assert.assertEquals(3, b.getRenderPriority());
    }

    @Test
    public void getSymbol() {
        Assert.assertEquals('j', b.getSymbol());
    }

    @Test
    public void execute() {
        Player p = new Player(1, new Vector2(0,2), 0);
        p.rotate(1,2);
        p.move(1,1);
        p.move(1,1);
        b.execute(p);
        Assert.assertEquals(new Vector2(0,1), p.getPos());
    }

}