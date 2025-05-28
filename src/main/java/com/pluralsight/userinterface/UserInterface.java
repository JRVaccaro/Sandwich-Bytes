package com.pluralsight.userinterface;

import com.pluralsight.orders.Order;
import com.pluralsight.sandwichmodels.Bread;
import com.pluralsight.sandwichmodels.Sandwich;

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
                 Bread bread = promptForBread();
                   int size = promptForSize();
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

    public Bread promptForBread() {
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
    public int promptForSize(){
        while (true){
            System.out.println("Select sandwich size:");
            System.out.println("1) 4 inches");
            System.out.println("2) 8 inches");
            System.out.println("3) 12 inches");

            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice){
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
}