package com.pluralsight.sandwichmodels;

public class RegularTopping extends Toppings{

    public RegularTopping(String type) {//Constructor that sets the type of regular topping
        super(type); //Calls the constructor in the Toppings superclass
    }

    @Override
    public double getPrice() {
        //no additional cost for regular toppings, it's included in price
        return 0;

    }
}