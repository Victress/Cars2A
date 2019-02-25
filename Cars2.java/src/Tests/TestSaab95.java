package Tests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Saab95;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 *A test for Model.Saab95
 *
 * @return
 */

public class TestSaab95 {
    private Saab95 saab95;

    @Before
    public void before() {
        saab95 = new Saab95();
    }

    @Test
    public void TestingMove() throws Exception {
        saab95.move();
        assertEquals(8.0, saab95.getY());
    }

    @Test
    public void TestingTurningLeft (){
        saab95.turnLeft();
        assertEquals(Saab95.directions.LEFT,saab95.getCurrentDirection());
    }
    @Test
    public void TestingTurningRight (){
        saab95.turnRight();
        assertEquals(Saab95.directions.RIGHT,saab95.getCurrentDirection());
    }

    @Test
    public void TestingGasTurboOFF()throws Exception{
        saab95.setTurboOff();
        saab95.gas(0.1);
        assertEquals(8.125,saab95.getCurrentSpeed());
    }
    @Test
    public void TestingBrakeTurboOFF() throws Exception{
        saab95.setTurboOff();
        saab95.brake(0.1);
        assertEquals(7.875, saab95.getCurrentSpeed());
    }

    @Test
    public void TestingGas()throws Exception{
        saab95.setTurboOn();
        saab95.gas(0.1);
        assertEquals(8.1625,saab95.getCurrentSpeed());
    }
    @Test
    public void TestingBrake()throws Exception{
        saab95.setTurboOn();
        saab95.brake(0.1);
        assertEquals(7.8375,saab95.getCurrentSpeed());
    }
    @After
    public void after() {
        saab95 = null;
        assertNull(saab95);
    }

}