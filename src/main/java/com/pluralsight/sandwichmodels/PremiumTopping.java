package com.pluralsight.sandwichmodels;

public abstract class PremiumTopping extends Toppings{
    public PremiumTopping(String type) { //Constructor that sets the type of premium
        super(type); //Calls the constructor in the Toppings superclass
    }

    //Premium topping will define it's own price
    @Override
    public abstract double getPrice();

    }

