package Model;

import java.awt.*;
import java.util.ArrayList;

public class Workshops<T extends Vehicles> implements IWorkShops {

    public int maxCars = 10;
    ArrayList<T> ListOfCars;

    @Override
    public boolean isWorkShopFull(){
        if (maxCars== ListOfCars.size() ){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void moveIn() {

    }

    @Override
    public void moveOut() {

    }


    public void moveIn(T vehicles) {

        if (isWorkShopFull()){
            System.out.println("ERROR; too manny cars");
        }else {
            ListOfCars.add(vehicles);
        }
    }

    public void moveOut(T vehicles) {
        vehicles =  ListOfCars.get(0);


    }
}
