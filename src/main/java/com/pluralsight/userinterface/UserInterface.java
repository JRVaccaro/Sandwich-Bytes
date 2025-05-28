package com.pluralsight.userinterface;

import com.pluralsight.orders.Order;
import com.pluralsight.sandwichmodels.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order order;

    public UserInterface() {
        scanner = new Scanner(System.in);
        this.order = new Order();
    }

    public void display() {

        boolean exit = false;
        while (!exit) {

            System.out.println("Welcome to Sandwich Bytes!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.println("Please choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    processNewOrder();
                    break;

                case "0":
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void processNewOrder() {
        boolean ordering = true;

        while (ordering) {

            System.out.println("Order Menu:");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) CHECKOUT");
            System.out.println("0) Cancel Order");

            System.out.println("Please choose an option: ");
            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    addNewSandwich();
                    break;

                case "2":
                    //call to method
                    break;

                case "3":
                    //call to method
                    break;

                case "4":
                    //call to method
                    break;

                case "0":
                    System.out.println("Order has been cancelled.");
                    ordering = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    private void addNewSandwich() {

        Bread bread = promptForBread();
        int size = promptForSize();
        PremiumTopping meat = promptForPremiumMeat();

        List<Toppings> toppings = promptForToppings();
        toppings.add(meat);


        //If user wants extra meat, add additional meat
        List<PremiumTopping> extraMeats = promptForAdditionalPremiumMeats();
        toppings.addAll(extraMeats);
    }

    private Bread promptForBread() {
        while (true) {

            System.out.println("Select your bread type");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");

            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    return new Bread("White");
                //Using return to exit from loop

                case "2":
                    return new Bread("Wheat");


                case "3":
                    return new Bread("Rye");

                case "4":
                    return new Bread("Wrap");

                default:
                    System.out.println("Invalid bread choice. Please try again.");
            }
        }
    }

    //Prompting user to select sandwich size and returns selected size in inches
    private int promptForSize() {
        while (true) {
            System.out.println("Select sandwich size:");
            System.out.println("1) 4 inches");
            System.out.println("2) 8 inches");
            System.out.println("3) 12 inches");

            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    return 4;

                case "2":
                    return 8;

                case "3":
                    return 12;

                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        }
    }

    private List<Toppings> promptForToppings() {
        List<Toppings> toppings = new ArrayList<>();

        System.out.println("--- Toppings Selection ---");
        return toppings;
    }

    //Prompts user to select meat topping for sandwich
    private PremiumTopping promptForPremiumMeat() {
        while (true) {
            System.out.println("--- Select Main Premium Meat Topping ---");
            System.out.println("1) Steak");
            System.out.println("2) Ham");
            System.out.println("3) Salami");
            System.out.println("4) Roast Beef");
            System.out.println("5) Chicken");
            System.out.println("6) Bacon");

            String choice = scanner.nextLine().trim();


            //Return a new meat object based on user choice
            switch (choice) {
                case "1":
                    return new Meat("Steak");

                case "2":
                    return new Meat("Ham");

                case "3":
                    return new Meat("Salami");

                case "4":
                    return new Meat("Roast Beef");

                case "5":
                    return new Meat("Chicken");

                case "6":
                    return new Meat("Bacon");

                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        }
    }

    //Prompting user if they want extra meat toppings
    private List<PremiumTopping> promptForAdditionalPremiumMeats() {
        List<PremiumTopping> extraMeat = new ArrayList<>();

        while (true) {
            System.out.println("Would you like to add extra meat? (yes or no)");
            String answer = scanner.nextLine().trim();

            //if yes, reuse meat prompt method and add choice to list
            if (answer.equalsIgnoreCase("yes")) {
                PremiumTopping extra = promptForPremiumMeat();
                extraMeat.add(extra);
                //if no, exit from loop
            } else if (answer.equalsIgnoreCase("no")) {
                break;

            } else {
                System.out.println("Invalid choice. Please enter yes or no.");
            }
        }
        return extraMeat;
    }

    private PremiumTopping promptForPremiumCheese() {

        while (true) {
            System.out.println("--- Select Main Premium Cheese Topping ---");
            System.out.println("1) American");
            System.out.println("2) Provolone");
            System.out.println("3) Cheddar");
            System.out.println("4) Swiss");

            String choice = scanner.nextLine().trim();

            //Return a new cheese object based on user choice
            switch (choice) {
                case "1":
                    return new Cheese("American");

                case "2":
                    return new Cheese("Provolone");

                case "3":
                    return new Cheese("Cheddar");

                case "4":
                    return new Cheese("Swiss");

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}