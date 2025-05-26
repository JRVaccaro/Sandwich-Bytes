package com.pluralsight.sandwichmodels;

public class Cheese extends PremiumTopping{
    public Cheese(String type) {
        super(type);
    }

    @Override
    public double getPrice() {
        //Price is determined in Sandwich class based on sandwich size.
        return 0;
    }
}
