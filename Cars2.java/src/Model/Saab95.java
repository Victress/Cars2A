package Model;

import Model.Cars;

import java.awt.*;

/**
 * Class for a Saa95
 */
public class Saab95 extends Cars {

    private boolean turboOn;

    public Saab95(){
        super(2,125,0,directions.UP,"Model.Saab95",Color.RED,0,0,2.0,4.7);
        turboOn = false;

        //stopEngine();
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public boolean hasTurbo (){
        return true;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3; //1.3
        return enginePower * 0.01 * turbo;
    }
    @Override
    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }
    @Override
    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }

    @Override
    public void gas(double amount){
        if (engineOn && amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

}