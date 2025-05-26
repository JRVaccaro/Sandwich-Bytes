package com.pluralsight.sandwichmodels;

public class RegularTopping extends Toppings{
    public RegularTopping(String type) {
        super(type);
    }

    @Override
    public double getPrice() {
        //no additional cost for regular toppings, it's included in price
        return 0;

    }
}

