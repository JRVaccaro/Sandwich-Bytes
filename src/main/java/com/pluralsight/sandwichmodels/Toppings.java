package com.pluralsight.sandwichmodels;

import com.pluralsight.interfaces.Priceable;

public abstract class Toppings implements Priceable {
    private String type;

    public Toppings(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //abstract method to get the price of the topping, which will be used in all subclasses
    @Override
    public abstract double getPrice();
    }

