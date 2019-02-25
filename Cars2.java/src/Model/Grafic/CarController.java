package Model.Grafic;

import Model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicles> cars = new ArrayList<>();
    //ArrayList<ModelTruck> trucks = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());

        cc.cars.add(new Saab95());

        cc.cars.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicles car : cars) {
                if((int)car.getY()<= -1){
                    car.turnRight();
                    car.turnRight();
                }else if ((int)car.getY()+60 >= (CarView.Y - 240)  ) {
                    car.turnRight();
                    car.turnRight();
                }else{
                }
                car.move();
                //System.out.println(car.getCurrentSpeed());

                int x = (int) Math.round(car.getX()); // stod getpos.getx
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(car ,x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }

        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicles car : cars) {
            car.gas(gas);
        }
    }

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicles car : cars) {
            car.brake(brake);
        }
    }

    public void startEngine() {
        for (Vehicles car : cars) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (Vehicles car : cars) {
            car.stopEngine();
        }
    }


    public void turboOn(){ // try med eception samt cast saab abstrakt metod hasturboo i vehales
        for(Vehicles car: cars){
            if (car.hasTurbo()){
                ((Saab95)car).setTurboOn();
            }
        }
    }

    public void turboOff() {
        for (Vehicles car : cars) {
            if (car.hasTurbo()) {
                ((Saab95)car).setTurboOff();
            }
        }
    }

    public void liftBed(){
        for (Vehicles truck: cars){
            if (!((ModelTruck)truck).isRampUp() && truck.getCurrentSpeed()==0){
                ((ModelTruck)truck).moveUpRamp();

            }
        }
    }

    public void lowerBed(){
        for (Vehicles truck: cars) {
            if (((ModelTruck)truck).isRampUp() && truck.getCurrentSpeed()==0) {
                ((ModelTruck)truck).moveDownRamp();

            }
        }
    }
}

