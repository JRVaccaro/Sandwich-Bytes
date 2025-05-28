package com.pluralsight.userinterface;

import com.pluralsight.orders.Order;
import com.pluralsight.orders.Receipt;
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
                    addNewDrink();
                    break;

                case "3":
                    addNewChips();
                    break;

                case "4":
                    checkout();
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
        //Prompt user to select bread type
        Bread bread = promptForBread();
        //Prompt user to select sandwich size
        int size = promptForSize();

        //Prompt user for main meat and any extra meat
        PremiumTopping meat = promptForPremiumMeat();
        List<PremiumTopping> extraMeats = promptForAdditionalPremiumMeats();

        //Prompt user for main cheese and any extra cheeses
        PremiumTopping cheese = promptForPremiumCheese();
        List<PremiumTopping> extraCheeses = promptForAdditionalPremiumCheeses();


        //Collects all toppings for sandwich
        List<Toppings> toppings = promptForToppings();

        //Add main and any extra meat to list
        toppings.add(meat);
        toppings.addAll(extraMeats);

        //Add main and any extra cheese to list
        toppings.add(cheese);
        toppings.addAll(extraCheeses);

        //Add sauces to list
        toppings.addAll(promptForSauces());

        //Prompt if sandwich should be toasted
        boolean toasted = promptForToasting();


        //Checking if extra cheese or meat were added
        boolean hasExtraCheese = !extraCheeses.isEmpty();
        boolean hasExtraMeat = !extraMeats.isEmpty();


        //Creates new Sandwich object with information
        Sandwich sandwich = new Sandwich(size, bread, toasted, toppings, hasExtraCheese, hasExtraMeat);


        //Add sandwich to current order
        order.addItem(sandwich);

        System.out.println("Sandwich has been added to your order.");

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

            //Return a new bread object based on user choice
            switch (choice) {
                case "1":
                    return new Bread("White");


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

    //Prompt user to select toppings for sandwich
    private List<Toppings> promptForToppings() {
        List<Toppings> toppings = new ArrayList<>();

        System.out.println("--- Regular Toppings Selection ---");
        System.out.println("1) Lettuce");
        System.out.println("2) Peppers");
        System.out.println("3) Onions");
        System.out.println("4) Tomatoes");
        System.out.println("5) Jalapenos");
        System.out.println("6) Cucumbers");
        System.out.println("7) Pickles");
        System.out.println("8) Guacamole");
        System.out.println("9) Mushrooms");
        System.out.println("0) Done adding toppings");


        while (true) {
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                break; //done adding toppings
            }

            switch (choice) {
                case "1":
                    toppings.add(new RegularTopping("Lettuce"));
                    break;

                case "2":
                    toppings.add(new RegularTopping("Peppers"));
                    break;

                case "3":
                    toppings.add(new RegularTopping("Onions"));
                    break;

                case "4":
                    toppings.add(new RegularTopping("Tomatoes"));
                    break;

                case "5":
                    toppings.add(new RegularTopping("Jalapenos"));
                    break;

                case "6":
                    toppings.add(new RegularTopping("Cucumbers"));
                    break;

                case "7":
                    toppings.add(new RegularTopping("Pickles"));
                    break;

                case "8":
                    toppings.add(new RegularTopping("Guacamole"));
                    break;

                case "9":
                    toppings.add(new RegularTopping("Mushrooms"));
                    break;

                default:
                    System.out.println("Invalid choice. Please try again");

            }
        }
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

    //Prompting user if they want extra cheese
    private List<PremiumTopping> promptForAdditionalPremiumCheeses() {
        List<PremiumTopping> extraCheese = new ArrayList<>();
        while (true) {
            System.out.println("Would you like to add extra cheese? (yes or no)");
            String answer = scanner.nextLine().trim();

            //if yes, reuse cheese prompt method and add choice to list
            if (answer.equalsIgnoreCase("yes")) {
                PremiumTopping extra = promptForPremiumCheese();
                extraCheese.add(extra);
                //if no, exit from loop
            } else if (answer.equalsIgnoreCase("no")) {
                break;

            } else {
                System.out.println("Invalid choice. Please enter yes or no.");
            }
        }
        return extraCheese;
    }

    private List<Toppings> promptForSauces() {
        List<Toppings> toppings = new ArrayList<>();
        System.out.println("--- Sauce Selection ---");
        System.out.println("1) Mayo");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) Ranch");
        System.out.println("5) Thousand Islands Sauce");
        System.out.println("6) Vinaigrette");
        System.out.println("0) Done adding sauces");

        while (true) {
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                break; //done adding sauces

            }
            switch (choice) {
                case "1":
                    toppings.add(new Sauce("Mayo"));
                    break;

                case "2":
                    toppings.add(new Sauce("Mustard"));
                    break;

                case "3":
                    toppings.add(new Sauce("Ketchup"));
                    break;

                case "4":
                    toppings.add(new Sauce("Ranch"));
                    break;

                case "5":
                    toppings.add(new Sauce("Thousand Islands Sauce"));
                    break;

                case "6":
                    toppings.add(new Sauce("Vinaigrette"));
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        return toppings;
    }

    private boolean promptForToasting() {
        while (true) {
            System.out.println("Would you like sandwich toasted? (Yes or No)");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")) {
                return true;

                //if no, exit from loop
            } else if (answer.equalsIgnoreCase("no")) {
                return false;

            } else {
                System.out.println("Invalid choice. Please enter yes or no.");
            }
        }

    }

    private void addNewDrink() {
        String size = promptForDrinkSize();

        String flavor = promptForDrinkFlavor();


        Drink drink = new Drink(size, flavor);
        order.addItem(drink);


        System.out.println("Drink has been added to your order.");
    }


    private String promptForDrinkSize() {

        while (true) {
            System.out.println("--- Choose a drink size ---");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");

            String choice = scanner.nextLine().trim();


            switch (choice) {
                case "1":
                    return "Small";

                case "2":
                    return "Medium";


                case "3":
                    return "Large";


                default:
                    System.out.println("Invalid choice. Please try again");

            }
        }
    }

    private String promptForDrinkFlavor() {
        while (true) {
            System.out.println("--- Choose a drink flavor ---");
            System.out.println("1) Water");
            System.out.println("2) Soda");
            System.out.println("3) Juice");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    return "Water";

                case "2":
                    return "Soda";

                case "3":
                    return "Juice";

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
    private void addNewChips(){
        String flavor = promptForChipsFlavor();
        Chips chips = new Chips(flavor);
        order.addItem(chips);
        System.out.println("Chips has been added to your order.");
    }
    //Helper method
    private String promptForChipsFlavor(){
        while (true){
            System.out.println("--- Choose a chips flavor ---");
            System.out.println("1) Potato");
            System.out.println("2) BBQ");
            System.out.println("3) Spicy");

            String choice = scanner.nextLine().trim();

            switch (choice){
                case "1":
                    return "Potato";

                case "2":
                    return "BBQ";

                case "3":
                    return "Spicy";

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }
    private void checkout(){
        System.out.println("--- Your Order ---");
        for (Item item : order.getItems()){
            System.out.println(item.toString());
        }
        System.out.printf("Total Price: $.2f\n", order.getTotalPrice());

        System.out.println("Confirm Order: (Yes or No)");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("yes")){
            Receipt receipt = new Receipt(order);

            //Show receipt on console
            System.out.println(receipt.generateReceiptText());

            //Save receipt to file
            receipt.saveReceiptToFile();
            System.out.println("Order has been confirmed.");

            //Clear order after confirmation
            order.clearOrder();
        } else if (input.equalsIgnoreCase("no")) {

            //Cancel order
            order.clearOrder();
            System.out.println("Order has been canceled");


        } else {
            System.out.println("Invalid input. Please enter Yes or No.");

        }
    }


}