package Model;

import java.awt.*;

/**
 * This is an abstract class that extends vehicles. The purpose of this class is to make it possible for us use some of
 * the characteristics that vehicles has, but not all of them.
 */

public abstract class Cars extends Vehicles {

    public boolean isLoaded = false;


    /**
     * This is a constructor for Vehicles.
     * @param nrDoors Number of doors on the car
     * @param enginePower the cars engine power
     * @param currentSpeed the speed the car has
     * @param currentDirection direction of a driving car
     * @param modelName the model of the car
     * @param color color of car
     * @param x a x-coordinate for direction
     * @param y a y-coordinate for direction
     * @return Variables
     */

    public Cars(int nrDoors, double enginePower, double currentSpeed, directions currentDirection, String modelName, Color color, double x, double y, double widthCars, double lengthCars) {
        super(nrDoors, enginePower, currentSpeed, currentDirection, modelName, color, x, y, widthCars, lengthCars);
    }


    /**
     * A method that stops the cars engine if the car is on the truck.
     *
     */

    @Override
    public void move(){
        if (isLoaded== true) {
            stopEngine();
        } else {
            super.move();

        }
    }
}
