package com.pluralsight.sandwichmodels;

public class Meat extends PremiumTopping{
    public Meat(String type) {
        super(type);
    }

    @Override
    public double getPrice() {
        //Price will be determined in Sandwich class based on sandwich size.
        return 0;
    }
}
