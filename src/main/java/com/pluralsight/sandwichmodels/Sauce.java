package com.pluralsight.sandwichmodels;

public class Sauce extends Toppings{
    //Constructor that passes the type of sauce to the Topping superclass
    public Sauce(String type) {
        super(type); //Calls the constructor in Topping class
    }

    @Override
    public double getPrice() {
        //no additional cost for sauce, it's included in price.
        return 0;
    }
}
