package Tests;
import Model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestTruck {

    private Truck truck;
    private Truck truck2;

    Cars cars;
    @Before
    public void before() {
        truck = new Truck();
        truck2 = new Truck();
        int maxAngle = 70;
        truck.getListCarsOnTruck();
    }

    @Test
    public void testingTurningLeft() {
        truck.turnLeft();
        assertEquals(Scania.directions.LEFT, truck.getCurrentDirection());
    }

    @Test
    public void testingTurningRight() {
        truck.turnRight();
        assertEquals(Scania.directions.RIGHT, truck.getCurrentDirection());
    }

    @Test
    public void testingMove() throws Exception {
        truck.move();
        assertEquals(8.0, truck.getY());
    }

    @Test
    public void testingGas() throws Exception {
        truck.gas(0.1);
        assertEquals(8.1875, truck.getCurrentSpeed());
    }

    @Test
    public void testingBrake() throws Exception {
        truck.brake(0.1);
        assertEquals(7.8125, truck.getCurrentSpeed());
    }

    @Test
    public void testingIsRampUp () throws Exception{
        truck.isRampUp();
        assertEquals(true,truck.isRampUp());

    }

    @Test
    public void TestingMaxAngle () throws Exception {
        Cars car1 = new Saab95();
        for(int i=0; i<=70; i++){
            truck.moveUpRamp();

        }
        truck.loadCarOnTruck(car1);
        assertEquals(1,truck.getListCarsOnTruck().size());
        truck2.loadCarOnTruck(car1);
        assertEquals(0, truck2.getListCarsOnTruck().size());
    }


    @Test
    public void testingUnloadCars () throws  Exception {
        Cars cars = new Saab95();
        truck.unLoadCarsFromTruck();
        assertEquals( 0, truck.getListCarsOnTruck().size());
    }

    @Test
    public void testingLoadCars() throws Exception{
        Cars car1 = new Saab95();
        truck.loadCarOnTruck(car1);
        truck.move();
        assertEquals(car1.getPos()== truck.getPos(), truck.getListCarsOnTruck().contains(cars));
    }

    @Test
    public void testingLoadedCarsDontMove() throws Exception {
        Cars car1 = new Saab95();
        truck.loadCarOnTruck(car1);
        car1.move();
        assertEquals(0, car1.getCurrentSpeed());
    }

    @After
    public void after(){
        truck= null;
        assertNull(truck);
    }
}