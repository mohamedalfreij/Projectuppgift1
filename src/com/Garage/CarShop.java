package com.Garage;

import java.util.ArrayList;

/**
 * Man kan spara, visa fordons info, och ta bort fordon
 * Vi har en klass (CarShop) som har hand om en ArrayList för "Vehicel".
 *
 * @author  Mohamed Al-Freij
 * @version 1.0
 * @since   2019-10-10
 */
public class CarShop {

    private ArrayList<Car> myCars;
    private Car car;
    private String carName;

    /**
     * Konstruktor
     */
    CarShop() {
        this.myCars = new ArrayList<>();
    }

    /**
     * Lägger till nytt fordon
     * @param car
     * @return false eller true
     */
    public boolean addNewCar(Car car) {
        if (findeCar(car.getName()) >= 0) {
            System.out.println("Fordonet är redan sparad.");
            return false;
        }

        myCars.add(car);
        return true;
    }

    /**
     * tar bort fordon
     * @param car
     * @return false eller true
     */
    public boolean removeCar(Car car) {
        this.car = car;
        int foundPosition = findeCar(car);
        if (foundPosition < 0) {
            System.out.println(car.getName() + ", gick inte att hitta.");
            return false;
        }

        this.myCars.remove(foundPosition);
        System.out.println(car.getName() + ", har tagits bort.");
        return true;
    }

    /**
     * hittar fordon
     * @param car
     * @return car
     */
    private int findeCar(Car car) {return this.myCars.indexOf(car);}

    /**
     * hittar fordon
     * @param carName
     * @return carName
     */
    private int findeCar(String carName) {
        for (int i = 0; i <this.myCars.size(); i++) {
            Car car = this.myCars.get(i);
            if (car.getName().equals(carName)){
                return i;
            }
        }
        return -1;
    }

    /**
     * Visar fordons info
     */

    public void printCar() {
        System.out.println("Fordonslista:");
        for (int i = 0; i <this.myCars.size(); i++) {
            System.out.println((i+1) + ". Märke: " +
                    this.myCars.get(i).getName() + " Modell: " +
                    this.myCars.get(i).getModel() + " Tophastighet: " +
                    this.myCars.get(i).getTopSpeed() + "km/h. " +
                    this.myCars.get(i).getSeats() + " Sittplatser " );
        }
    }

    /**
     *
     * @param car
     * @return null
     */
    public Car queryCar(String car) {
        int position = findeCar(car);
        if (position >= 0) {
            return this.myCars.get(position);
        }
        return null;
    }

}

