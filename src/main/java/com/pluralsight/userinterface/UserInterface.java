package com.pluralsight.userinterface;

import com.pluralsight.orders.Order;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Order order;

    public UserInterface(){
        scanner = new Scanner(System.in);
    }

    public void display(){

        boolean exit = false;
        while(!exit) {

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
    public void processNewOrder(){

    }
}
