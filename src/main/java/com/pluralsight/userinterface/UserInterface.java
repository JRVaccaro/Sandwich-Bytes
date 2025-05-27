package com.pluralsight.userinterface;

import com.pluralsight.orders.Order;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order order;

    public UserInterface() {
        scanner = new Scanner(System.in);
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
                    //call to method
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
}