package com.pluralsight.sandwichmodels;

import com.pluralsight.interfaces.Priceable;

public abstract class Item implements Priceable {
    @Override
    public abstract double getPrice();

    @Override
    public abstract String toString();
}
