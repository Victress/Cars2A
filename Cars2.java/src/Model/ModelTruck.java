package Model;

import java.awt.*;
import java.util.ArrayList;

/**
 *  An abstract class for the trucks, we have this because we want to be able to create different kinds of trucks,
 *  with different characteristics
 */

public abstract class ModelTruck extends Vehicles implements IRamp {

    private int angle;
    int maxAngle = 70;
    int minAngle = 0;
    protected ArrayList<Cars> ListCarsOnTruck;

    /**
     * A constructor for Volvo240 to connect wth cars
     * @param nrDoors number of doors on the car
     * @param enginePower enngien power of the car
     * @param currentSpeed the speed of the car
     * @param currentDirection direction of the car
     * @param modelName name of the car
     * @param color color of the car
     * @param x x-coordinate
     * @param y Y- coordinate
     * @param widthTruck- the trucks width
     * @param lengthTruck- the trucks length
     */

    public ModelTruck(int nrDoors, double enginePower, double currentSpeed, directions currentDirection, String modelName, Color color, double x, double y, double widthTruck, double lengthTruck) {
        super(nrDoors, enginePower, currentSpeed, currentDirection, modelName, color, x, y, widthTruck, lengthTruck);
        this.angle = 0;
        this.ListCarsOnTruck = new ArrayList();


    }


    /**
     * A method that checks if the ramp is up.
     * @return true or false
     */
    @Override
    public boolean isRampUp() {         //kollar om rampen är stängd öppen
        if (maxAngle == 70){
            return true;
        }else {

            return false;
        }}


    public void setAngle(int angle){
        this.angle=angle;
    }

    public int getAngle(){
        return angle;
    }

    /**
     * A method that checks if the ramp is up.
     * @return true or false
     */

    @Override
    public void moveUpRamp() {
        if(angle < maxAngle){
            this.angle = this.angle +1;
        }
    }

    /**
     * A method for moving the ramp down
     */

    @Override
    public void moveDownRamp() {
        if ( this.angle > minAngle){
            this.angle = this.angle - 1;
        }
    }

    @Override
    public void gas(double amount){
        if (amount >= 0 && amount <= 1 && isRampUp() == true) {
            incrementSpeed(amount);
        }
    }



}
