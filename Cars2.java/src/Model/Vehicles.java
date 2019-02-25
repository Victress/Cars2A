package Model;

import javax.swing.*;
import java.awt.*;
/**
 * The Vehicles-program has 2 type of cars.
 *
 * @author Eira Höglund
 * @author Sandra Svensson
 * @version 1.0
 * @since 2019-02-05
 * @return
 */
public abstract class Vehicles implements IMovable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected directions currentDirection;
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private double x;
    private double y;
    private Point pos;
    private double widthCars;
    private double lengthCars;
    protected boolean engineOn;

    /**
     * This is a constructor for Vehicles.
     * @param nrDoors Number of doors on the car
     * @param enginePower the cars engine power
     * @param currentSpeed the speed the car has
     * @param currentDirection direction of a driving car
     * @param modelName the model of the car
     * @param color color of car
     * @param x a x-cordinate for direction
     * @param y a y-cordinate for direction
     * @return Variables
     */


    //Constructor
    public Vehicles(int nrDoors, double enginePower, double currentSpeed, directions currentDirection, String modelName,
                    Color color, double x, double y, double widthCars, double lengthCars) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.currentDirection = currentDirection;
        this.modelName = modelName;
        this.color = color;
        this.x = x;
        this.y = y;
        this.widthCars = widthCars;
        this.lengthCars = lengthCars;
        this.pos = new Point(0,0);
        this.engineOn = false;
    }

    public abstract boolean hasTurbo ();

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public String getModelName(){return modelName;}


    public Point getPos() {
        return pos;
    }

    public double getWidthCars(){
        return widthCars;
    }



    public double getLengthCars (){
        return lengthCars;
    }
    /**
     * A setter for color
     */
    public void setWidthCars (double widthCars){
        this.widthCars = widthCars;

    }

    public void setLengthCars(double lengthCars) {
        this.lengthCars = lengthCars;
    }

    public void setColor(Color clr){
        this.color = clr;
    }

    public void setNrDoors(int nrDoors){
        this.nrDoors = nrDoors;
    }

    public void setEnginePower (double enginePower){
        this.enginePower = enginePower;
    }

    public void setCurrentSpeed(double currentSpeed) {
        if (currentSpeed >= 0 && currentSpeed <= enginePower) {
            this.currentSpeed = currentSpeed;
        }
    }

    public void setModelName (String modelName){
        this.modelName = modelName;
    }

    /**
     * A method to start the car
     */
    public void startEngine(){
        currentSpeed = 0.1;
        engineOn = true;
    }

    /**
     * A method to stop the car
     */
    public void stopEngine(){
        currentSpeed = 0;
        engineOn = false;
    }

    public void setCurrentDirection(directions currentDirection){
        this.currentDirection = currentDirection;
    }

    public directions getCurrentDirection(){
        return currentDirection;
    }


    /**
     * A method with cases to make the car move
     */
    @Override
    public void move() {
        switch (currentDirection) {
            case UP:
                y = y + currentSpeed;
                break;
            case LEFT:
                x = x + currentSpeed;
                break;
            case DOWN:
                y = y - currentSpeed;
                break;
            case RIGHT:
                x = x - currentSpeed;
                break;
        }
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    /**
     * A method for calculating the speedfactor
     * @return speedfactor
     */
    protected double speedFactor(){
        return 1;
    }

    /**
     * A method that increases the speed of the car
     * @param amount a double
     */
    protected void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * A method that decreases the speed of the car
     * @param amount a double that in this case (multiplie)....
     */
    protected void decrementSpeed(double amount){
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     * A method with an if-sats that creates the cars gas
     * @param amount is a double that in this case increment the speed if it is bigger/equal to 0 and bigger/equal to 1.
     */

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (engineOn && amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
            System.out.println(this.currentSpeed);
        }
    }

    /**
     * A method with an if-sats that creates the cars brake
     * @param amount a double (explain what it does)
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    /**
     * A method to make the car turn left
     */
    @Override
    public void turnLeft() {
        switch (currentDirection){
            case UP:
                currentDirection = directions.LEFT;
                break;
            case LEFT:
                currentDirection = directions.DOWN;
                break;
            case DOWN:
                currentDirection = directions.RIGHT;
                break;
            case RIGHT:
                currentDirection = directions.UP;
                break;
        }
    }

    /**
     * A method to make the car turn right
     */
    @Override
    public void turnRight() {
        switch (currentDirection){
            case UP:
                currentDirection = directions.RIGHT;
                break;
            case RIGHT:
                currentDirection = directions.DOWN;
                break;
            case DOWN:
                currentDirection = directions.LEFT;
                break;
            case LEFT:
                currentDirection = directions.UP;
                break;
        }

    }

    /**
     * 4 enums, UP,RIGHT,DOWN,LEFT
     */
    public enum directions{
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
}