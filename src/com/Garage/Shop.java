package com.Garage;

import java.util.Scanner;

import static com.Garage.Car.createCar;
import static java.lang.Integer.parseInt;

/**
 * Programmet hanterar Fordon (för ett Garage)
 * Man kan spara, visa fordons info, och ta bort fordon
 * Det finns en egen klass för fordon "Vehicel" (namn och antal säten).
 * Vi har en klass (CarShop) som har hand om en ArrayList för "Vehicel".
 * "CarShop" klassen har hand om all funktionalitet ovan.
 * Vi har en meny i mainklassen (den med static void main)
 * Alternativ i menyn:  Quit, Visa listan med fordon, Lägg till ett nytt fordon, Ta bort ett fordon, och visa alla val.
 *
 * @author  Mohamed Al-Freij
 * @version 1.0
 * @since   2019-10-10
 */
public class Shop {

    private static Scanner scanner = new Scanner(System.in);
    public static CarShop carShop = new Car("BMW", "4", "3-serie", 280);

    public static void main(String[] args){

        boolean quit = false;
        statrBil();
        printActions();
        while (!quit){
            System.out.println("\nVälj: (6 för att visa val)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("\nStänger ner...");
                    quit = true;
                    break;

                case 1:
                    carShop.printCar();
                    break;

                case 2:
                    addNewCar();
                    break;

                case 3:
                    removeCar();
                    break;

                case 6:
                    printActions();
                    break;
            }
        }
    }

    /**
     * Lägger till fordon
     * @return newCar
     */
    private static Car addNewCar(){
        System.out.println("Skriv in märket på fordonet: ");
        String name = scanner.nextLine();
        System.out.println("Skriv in antal säten: ");
        String tires = scanner.nextLine();
        System.out.println("Skriv in modellen på fordonet: ");
        String model = scanner.nextLine();
        System.out.println("Skriv in tophastighet på fordonet: ");
        int topSpeed = parseInt(scanner.nextLine());
        //Bil newBil = new Bil(name,model,topSpeed);
        Car newCar = createCar(name, tires, model, topSpeed);
        if(carShop.addNewCar(newCar)) {
            System.out.println("Ny bil tillagd: Namn: " + name + ", modell: " + model + ", Tophastighet: " + topSpeed);
        } else {
            System.out.println("Kan inte lägga till, " + name + " finns redan.");
        }
        return newCar;
    }

    /**
     * tar bort fordon
     */
    private static void removeCar() {
        System.out.println("Skriv in namnet på fordonet som skall bort: ");
        String name = scanner.nextLine();
        Car existingCarRecord = carShop.queryCar(name);
        if (existingCarRecord == null) {
            System.out.println("Kan inte hitta fordon.");
            return;
        }
        if(carShop.removeCar(existingCarRecord)) {
            System.out.println("Fordon har tagits bort!");
        } else {
            System.out.println("Kan inte ta bort fordon.");
        }
    }

    private static void statrBil(){System.out.println("Startar fordon...");}

    /**
     * Visar en lista på val.
     */
    private static void printActions(){
        System.out.println("\nVälj:\n");
        System.out.println("0 - Stänger verkstad\n" +
                "1 - Visa fordon\n" +
                "2 - Lägg till ett nytt fordon\n" +
                "3 - Ta bort fordon\n" +
                "6 - Visa en lista över alla val.");
    }
}
