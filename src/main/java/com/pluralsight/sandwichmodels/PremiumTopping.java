package com.pluralsight.sandwichmodels;

public abstract class PremiumTopping extends Toppings{
    public PremiumTopping(String type) {
        super(type);
    }

    @Override
    public abstract double getPrice();

    }

