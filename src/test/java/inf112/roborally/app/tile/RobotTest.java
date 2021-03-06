package inf112.roborally.app.tile;

import inf112.roborally.app.tile.tiles.Robot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RobotTest {

    private Robot robot;

    /**
     * Test canMoveIntoFrom()
     */
    @Test
    public void canMoveIntoFromTest() {
        robot = new Robot(1);
        assertFalse(robot.canMoveIntoFrom(90));
    }

    /**
     * Test canMoveOutFrom()
     */
    @Test
    public void canMoveOutFromTest() {
        robot = new Robot(1);
        assertFalse(robot.canMoveOutFrom(90));
    }

    /**
     * Test getId()
     */
    @Test
    public void getIdTest() {
        robot = new Robot(1);
        assertEquals(robot.getId(), 0);
    }

}
