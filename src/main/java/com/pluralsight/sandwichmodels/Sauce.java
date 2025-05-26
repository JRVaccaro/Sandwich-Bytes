package com.pluralsight.sandwichmodels;

public class Sauce extends Toppings{
    public Sauce(String type) {
        super(type);
    }

    @Override
    public double getPrice() {
        //no additional cost for sauce, it's included in price.
        return 0;
    }
}
