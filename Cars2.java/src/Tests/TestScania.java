package Tests;
import Model.Vehicles;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Model.Scania;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestScania {

    private Scania scania;

    @Before
    public void before() {
        scania = new Scania();
        int maxAngle = 70;
    }

    @Test
    public void testingTurningLeft() {
        scania.turnLeft();
        assertEquals(Scania.directions.LEFT, scania.getCurrentDirection());
    }

    @Test
    public void testingTurningRight() {
        scania.turnRight();
        assertEquals(Scania.directions.RIGHT, scania.getCurrentDirection());
    }

    @Test
    public void testingMove() throws Exception {
        scania.move();
        assertEquals(8.0, scania.getY());
    }

    @Test
    public void testingGas() throws Exception {
        scania.gas(0.1);
        assertEquals(8.1875, scania.getCurrentSpeed());
    }

    @Test
    public void testingBrake() throws Exception {
        scania.brake(0.1);
        assertEquals(7.8125, scania.getCurrentSpeed());
    }

    @Test
    public void testingIsRampUp () throws Exception{
        scania.isRampUp();
        assertEquals(true,scania.isRampUp());
    }


    @Test
    public void testingMOveRampDown () throws Exception {
        scania.moveDownRamp();
        assertEquals(0,scania.getAngle());
    }


    @After
    public void after(){
        scania = null;
        assertNull(scania);
    }
}
