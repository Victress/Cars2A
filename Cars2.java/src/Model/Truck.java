package Model;

import java.awt.*;
import java.util.ArrayList;

/**
 * A class for a certain truck
 */

public class Truck extends ModelTruck {

    private final int MaxCarsOnTruck = 3;
    private double TruckY, TruckX;
    private final static double trimFactor = 1.25;

    /**
     * An array-list that represents the cars on the truck
     *
     * @return How many cars it is on the truck
     */

    public ArrayList<Cars> getListCarsOnTruck() {
        return ListCarsOnTruck;
    }


    public Truck() {
        super(2, 150, 8.0, Vehicles.directions.UP, "Model.Truck", Color.pink, 0.0, 0.0, 3.5, 20.0);
    }

    protected double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }


    /**
     * A method with an if-statement that changes the cars position so that the cars position equals to the trucks.
     *
     * @param cars
     */

    public void changePositionCarsToTrucks(Cars cars) {
        if (ListCarsOnTruck.contains(cars)) {
            cars.getPos().x = this.getPos().x;
            cars.getPos().y = this.getPos().y;
        }
    }

    /**
     * A method that makes the cars have an reasonable position after they are onloaded from the truck.
     *
     * @param cars - a car from the class car
     * @return true or false
     */
    public void positionCarsOffTruck(Cars cars) {
        if (ListCarsOnTruck.contains(cars)) {
            cars.getPos().x = this.getPos().x + 2;
            cars.getPos().y = this.getPos().y + 2;
        }
    }

    /**
     * A method that checks if the car is close enough to the truck, to get on the truck.
     *
     * @param cars- a car from the class car
     * @return true or false
     */

    public boolean PositionCars(Cars cars) {
        if (Math.abs(cars.getPos().x - this.getPos().x) <= 2
                && Math.abs(cars.getPos().y - this.getPos().y) <= 2) {
            return true;
        } else {
            System.out.println("Can not load car on truck");
            return false;

        }
    }


    /**
     * A method that loads the cars on to the truck if all the statements are fulfilled.
     *
     * @param cars-
     */
    public void loadCarOnTruck(Cars cars) {
        if (isRampUp() && PositionCars(cars) && !ListCarsOnTruck.contains(cars) && ListCarsOnTruck.size() <= MaxCarsOnTruck &&
                cars.isLoaded== false ) {
            ListCarsOnTruck.add(cars);
            changePositionCarsToTrucks(cars);
            cars.isLoaded = true;
        } else {
            System.out.println("Truck full");
        }
    }

    /**
     * A method that unloads the cars from the truck if all the statements are fulfilled.
     * @param
     * @return cars
     */

    public Cars unLoadCarsFromTruck() { // interface turbobilar. lista av interface. lista av trucks. olika listor av bilar för att förenkla turboo och lift/lower bed
        if (isRampUp() && !ListCarsOnTruck.isEmpty()) {
            Cars cars = ListCarsOnTruck.remove(ListCarsOnTruck.size() - 1);
            positionCarsOffTruck(cars);
            cars.isLoaded = false;
            return cars;
        }

        return null;
    }


    @Override
    public boolean hasTurbo() {
        return false;
    }

    /**
     * A method that makes the cars on the truck move with the truck.
     *
     *
     */
    @Override
    public void move() {
        super.move();
        for(Cars cars : ListCarsOnTruck)
            changePositionCarsToTrucks(cars);


    }





}