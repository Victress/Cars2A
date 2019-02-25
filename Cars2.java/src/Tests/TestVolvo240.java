package Tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Volvo240;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 *A test for Model.Volvo240
 *
 * @return
 */

public class TestVolvo240 {
    private Volvo240 volvo240;

    @Before
    public void before() {
        volvo240 = new Volvo240();
    }

    @Test
    public void TestingMove() throws Exception {
        volvo240.move();
        assertEquals(8.0, volvo240.getY());
    }

    @Test
    public void TestTurningLeft() {
        volvo240.turnLeft();
        assertEquals(Volvo240.directions.LEFT, volvo240.getCurrentDirection());
    }

    @Test
    public void TestTurningRight() {
        volvo240.turnRight();
        assertEquals(Volvo240.directions.RIGHT, volvo240.getCurrentDirection());
    }

    @Test
    public void TestingGas() throws Exception {
        volvo240.gas(0.1);
        assertEquals(8.125, volvo240.getCurrentSpeed());
    }

    @Test
    public void TestingBrake() throws Exception {
        volvo240.brake(0.1);
        assertEquals(7.875, volvo240.getCurrentSpeed());
    }


    @After
    public void after() {
        volvo240 = null;
        assertNull(volvo240);
    }

}

