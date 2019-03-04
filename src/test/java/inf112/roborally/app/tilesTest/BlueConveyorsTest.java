package inf112.roborally.app.tilesTest;

import com.badlogic.gdx.math.Vector2;
import inf112.roborally.app.player.Player;
import inf112.roborally.app.tile.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlueConveyorsTest {
    private Player p = new Player(1, new Vector2(0,0), 0);
    private BlueConveyor bC = new BlueConveyor(90);
    private BlueConveyor2in1outLeft bC21L = new BlueConveyor2in1outLeft(90);
    private BlueConveyor2in1outRight bC21R = new BlueConveyor2in1outRight(90);
    private BlueConveyor2in1outStraight bC21S = new BlueConveyor2in1outStraight(90);
    private BlueConveyorTurnLeft bCTL = new BlueConveyorTurnLeft(90);
    private BlueConveyorTurnRight bCTR = new BlueConveyorTurnRight(90);

    @Test
    public void BlueConveyorPush(){
        Player temp = p;
        bC.execute(temp);
        bC.execute(temp);
        assertEquals(new Vector2(0,2), temp.getPos());
    }

    @Test
    public void BlueConveyor2in1outLeftPush(){
        Player temp = p;
        bC21L.execute(temp);
        bC21L.execute(temp);
        assertEquals(new Vector2(0,2), temp.getPos());
    }

    @Test
    public void BlueConveyor2in1outRightPush(){
        Player temp = p;
        bC21R.execute(temp);
        bC21R.execute(temp);
        assertEquals(new Vector2(0,2), temp.getPos());
    }

    @Test
    public void BlueConveyor2in1outStraightPush(){
        Player temp = p;
        bC21S.execute(temp);
        bC21S.execute(temp);
        assertEquals(new Vector2(0,2), temp.getPos());
    }

    @Test
    public void BlueConveyorTurnLeftPush(){
        Player temp = p;
        bCTL.execute(temp);
        bCTL.execute(temp);
        assertEquals(new Vector2(0,2), temp.getPos());
    }
    
    @Test
    public void BlueConveyorTurnRightPush(){
        Player temp = p;
        bCTR.execute(temp);
        bCTR.execute(temp);
        assertEquals(new Vector2(0,2), temp.getPos());
    }
}
