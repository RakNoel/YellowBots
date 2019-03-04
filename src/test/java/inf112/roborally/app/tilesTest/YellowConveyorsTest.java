package inf112.roborally.app.tilesTest;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YellowConveyorsTest {
    private Player p = new Player(1, new Vector2(0,0), 0);
    private YellowConveyor yC = new YellowConveyor(90);
    private YellowConveyor2in1outLeft yC21L = new YellowConveyor2in1outLeft(90);
    private YellowConveyor2in1outRight yC21R = new YellowConveyor2in1outRight(90);
    private YellowConveyor2in1outStraight yC21S = new YellowConveyor2in1outStraight(90);
    private YellowConveyorTurnLeft yCTL = new YellowConveyorTurnLeft(90);
    private YellowConveyorTurnRight yCTR = new YellowConveyorTurnRight(90);

    @Test
    public void YellowConveyorPush(){
        Player temp = p;
        yC.execute(temp);
        assertEquals(new Vector2(0,1), temp.getPos());
    }

    @Test
    public void YellowConveyor2in1outLeftPush(){
        Player temp = p;
        yC21L.execute(temp);
        assertEquals(new Vector2(0,1), temp.getPos());
    }

    @Test
    public void YellowConveyor2in1outRightPush(){
        Player temp = p;
        yC21R.execute(temp);
        assertEquals(new Vector2(0,1), temp.getPos());
    }

    @Test
    public void YellowConveyor2in1outStraightPush(){
        Player temp = p;
        yC21S.execute(temp);
        assertEquals(new Vector2(0,1), temp.getPos());
    }

    @Test
    public void YellowConveyorTurnLeftPush(){
        Player temp = p;
        yCTL.execute(temp);
        assertEquals(new Vector2(0,1), temp.getPos());
    }

    @Test
    public void YellowConveyorTurnRightPush(){
        Player temp = p;
        yCTR.execute(temp);
        assertEquals(new Vector2(0,1), temp.getPos());
    }
}
