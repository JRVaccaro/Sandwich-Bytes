package com.pluralsight.sandwichmodels;

import com.pluralsight.interfaces.Priceable;

public abstract class Toppings implements Priceable {
    @Override
    public abstract double getPrice();
    }

