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

            System.out.println("---Welcome to Sandwich Bytes!---");
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

            System.out.println("--- Order Menu ---");
            System.out.println("1) Create Sandwich");
            System.out.println("2) Signature Sandwiches");
            System.out.println("3) Add Chips");
            System.out.println("4) Add Drink");
            System.out.println("5) CHECKOUT");
            System.out.println("0) Cancel Order");

            System.out.println("Please choose an option: ");
            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    addNewSandwich();
                    break;

                case "2":
                    displaySignatureSandwiches();
                    break;

                case "3":
                    addNewChips();
                    break;

                case "4":
                    addNewDrink();
                    break;

                case "5":
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
                    System.out.println("You have selected white bread.");
                    return new Bread("White");


                case "2":
                    System.out.println("You have selected wheat bread.");
                    return new Bread("Wheat");


                case "3":
                    System.out.println("You have selected rye bread.");
                    return new Bread("Rye");

                case "4":
                    System.out.println("You have selected wrap bread.");
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
                    System.out.println("You have selected 4 inch sandwich size.");
                    return 4;


                case "2":
                    System.out.println("You have selected 8 inch sandwich size.");
                    return 8;

                case "3":
                    System.out.println("You have selected 12 inch sandwich size.");
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
            System.out.println("Enter your choices, when done selecting enter '0'");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                break; //done adding toppings
            }

            switch (choice) {
                case "1":
                    toppings.add(new RegularTopping("Lettuce"));
                    System.out.println("Lettuce has been added.");
                    break;

                case "2":
                    toppings.add(new RegularTopping("Peppers"));
                    System.out.println("Peppers has been added.");
                    break;

                case "3":
                    toppings.add(new RegularTopping("Onions"));
                    System.out.println("Onions has been added.");
                    break;

                case "4":
                    toppings.add(new RegularTopping("Tomatoes"));
                    System.out.println("Tomatoes has been added.");
                    break;

                case "5":
                    toppings.add(new RegularTopping("Jalapenos"));
                    System.out.println("Jalapenos has been added.");
                    break;

                case "6":
                    toppings.add(new RegularTopping("Cucumbers"));
                    System.out.println("Cucumbers has been added.");
                    break;

                case "7":
                    toppings.add(new RegularTopping("Pickles"));
                    System.out.println("Pickles has been added.");
                    break;

                case "8":
                    toppings.add(new RegularTopping("Guacamole"));
                    System.out.println("Guacamole has been added.");
                    break;

                case "9":
                    toppings.add(new RegularTopping("Mushrooms"));
                    System.out.println("Mushrooms has been added.");
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
                    System.out.println("You have selected steak.");
                    return new Meat("Steak");

                case "2":
                    System.out.println("You have selected ham.");
                    return new Meat("Ham");

                case "3":
                    System.out.println("You have selected salami");
                    return new Meat("Salami");

                case "4":
                    System.out.println("You have selected roast beef.");
                    return new Meat("Roast Beef");

                case "5":
                    System.out.println("You have selected chicken.");
                    return new Meat("Chicken");

                case "6":
                    System.out.println("You have selected bacon.");
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
                    System.out.println("You have selected american cheese.");
                    return new Cheese("American");

                case "2":
                    System.out.println("You have selected provolone cheese.");
                    return new Cheese("Provolone");

                case "3":
                    System.out.println("You have selected cheddar cheese.");
                    return new Cheese("Cheddar");

                case "4":
                    System.out.println("You have selected swiss cheese.");
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
            System.out.println("Enter your choices, when done selecting enter '0'");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                break; //done adding sauces

            }
            switch (choice) {
                case "1":
                    System.out.println("You have selected mayo.");
                    toppings.add(new Sauce("Mayo"));
                    break;

                case "2":
                    System.out.println("You have selected mustard.");
                    toppings.add(new Sauce("Mustard"));
                    break;

                case "3":
                    System.out.println("You have selected ketchup.");
                    toppings.add(new Sauce("Ketchup"));
                    break;

                case "4":
                    System.out.println("You have selected ranch.");
                    toppings.add(new Sauce("Ranch"));
                    break;

                case "5":
                    System.out.println("You have selected Thousand Islands sauce.");
                    toppings.add(new Sauce("Thousand Islands Sauce"));
                    break;

                case "6":
                    System.out.println("You have selected vinaigrette.");
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
        //Asks the user to select drink size
        String size = promptForDrinkSize();

        //Asks user to select drink flavor
        String flavor = promptForDrinkFlavor();

        //create a new drink object
        Drink drink = new Drink(size, flavor);

        //Add drink to current order
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

            //Return- sends a value back to where method was called from and stops the method execution.
            switch (choice) {
                case "1":
                    System.out.println("You selected small drink.");
                    return "Small";

                case "2":
                    System.out.println("You selected medium drink.");
                    return "Medium";


                case "3":
                    System.out.println("You selected large drink.");
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


            //Return- sends a value back to where method was called from and stops the method execution.
            switch (choice) {
                case "1":
                    System.out.println("You selected water.");
                    return "Water";

                case "2":
                    System.out.println("You selected soda.");
                    return "Soda";

                case "3":
                    System.out.println("You selected juice.");
                    return "Juice";

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
    //Method handles adding new chips to current order
    private void addNewChips() {

        //Asks user to select chip flavor
        String flavor = promptForChipsFlavor();

        //Creates a new chips object with selected flavor
        Chips chips = new Chips(flavor);

        //Add chips to current order
        order.addItem(chips);

        System.out.println("Chips has been added to your order.");
    }

    //Helper method
    private String promptForChipsFlavor() {
        while (true) {
            System.out.println("--- Choose a chips flavor ---");
            System.out.println("1) Potato");
            System.out.println("2) BBQ");
            System.out.println("3) Spicy");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                //Return- sends a value back to where method was called from and stops the method execution.
                case "1":
                    System.out.println("You selected potato chips");
                    return "Potato";

                case "2":
                    System.out.println("You selected BBQ chips.");
                    return "BBQ";

                case "3":
                    System.out.println("You selected spicy chips.");
                    return "Spicy";

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    private void checkout() {
        if (order.getItems().isEmpty()) {
            System.out.println("Your order is empty. Please add something before checking out.");
            return;
        }

        System.out.println("--- Your Order ---");
        for (Item item : order.getItems()) {
            System.out.println(item.toString());
        }
        System.out.printf("Total Price: $%.2f\n", order.getTotalPrice());

        System.out.println("Confirm Order: (Yes or No)");
        String input = scanner.nextLine().trim();

        if (input.equalsIgnoreCase("yes")) {
            Receipt receipt = new Receipt(order);

            //Show receipt on console
            System.out.println(receipt.generateReceiptText());

            //Save receipt to file
            receipt.saveReceiptToFile();
            System.out.println("Order has been confirmed. Returning to previous screen...");

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

    private void displaySignatureSandwiches() {
        System.out.println("--- Signature Sandwiches ---");
        System.out.println("1) The Knuckle Sandwich");
        System.out.println("2) The Taternator Sandwich");
        System.out.println("0) Return to previous menu");


        while (true) {
            System.out.println("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                break; //Return to previous menu
            }
            //Return- sends a value back to where method was called from and stops the method execution.
            switch (choice) {
                case "1":
                    addSignatureKnuckleSandwich();
                    return; //Exit from method and loop; goes back to menu options

                case "2":
                    addSignatureTaternatorSandwich();
                    return; //Exit from method and loop; goes back to menu options

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    private void addSignatureKnuckleSandwich() {
        SignatureKnuckleSandwich signatureSandwich = new SignatureKnuckleSandwich();

        System.out.println("---You selected the Knuckle Sandwich---");
        System.out.println("It comes with these toppings:");
        for (Toppings toppings : signatureSandwich.getToppings()) {
            System.out.println(toppings.getType());
        }
        while (true) {
            System.out.println("---Would you like to customize it? (Yes or No)---");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")) {
                customizeSignatureSandwich(signatureSandwich);
                System.out.println("---Customized Knuckle Sandwich added to your order---\n");
                break;

            } else if
            (answer.equalsIgnoreCase("no")) {
                order.addItem(signatureSandwich);
                System.out.println("---Added the Knuckle Sandwich to your order---\n");

                break;

            } else {
                System.out.println("Invalid response. Please enter (Yes or No).");
            }
        }
    }

    private void customizeSignatureSandwich(Sandwich sandwich) {
        while (true) {
            System.out.println("\nCurrent toppings");
            for (Toppings topping : sandwich.getToppings()) {
                System.out.println(topping.getType());
            }
            System.out.println("---Select an option---");
            System.out.println("1) Remove a topping");
            System.out.println("2) Add a new topping");
            System.out.println("0) Done customizing");

            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("0")) {
                order.addItem(sandwich);
                break;
            } else if (input.equalsIgnoreCase("1")) {
                System.out.println("---Enter the name of the topping to remove---");
                String toppingToRemove = scanner.nextLine().trim();
                boolean removed = sandwich.removeTopping(toppingToRemove);

                if (removed) {
                    System.out.println(toppingToRemove + " removed from the sandwich");
                } else {
                    System.out.println(toppingToRemove + " was not found on this sandwich");
                }
            } else if (input.equalsIgnoreCase("2")) {
                addToppingToSandwich(sandwich);

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

        private void addToppingToSandwich(Sandwich sandwich){
            System.out.println("---Choose toppings to add---");
            List<Toppings> newToppings = promptForToppings();

            for (Toppings toppings : newToppings){
                sandwich.addTopping(toppings);
                System.out.println(toppings.getType() + " added to the sandwich.");
            }

        }
    private void addSignatureTaternatorSandwich(){
        SignatureTaternatorSandwich signatureSandwich = new SignatureTaternatorSandwich();

        System.out.println("---You selected the Taternator Sandwich---");
        System.out.println("It comes with these toppings:");
        for (Toppings toppings : signatureSandwich.getToppings()) {
            System.out.println(toppings.getType());
        }
        while (true) {
            System.out.println("---Would you like to customize it? (Yes or No)---");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("yes")) {
                customizeSignatureSandwich(signatureSandwich);
                System.out.println("---Customized Taternator Sandwich added to your order---\n");
                break;

            } else if
            (answer.equalsIgnoreCase("no")) {
                order.addItem(signatureSandwich);
                System.out.println("---Added the Taternator Sandwich to your order---\n");

                break;

            } else {
                System.out.println("Invalid response. Please enter (Yes or No).");
            }
        }
    }

}

