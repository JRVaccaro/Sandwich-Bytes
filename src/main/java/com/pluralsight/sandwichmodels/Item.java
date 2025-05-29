package com.pluralsight.sandwichmodels;

import com.pluralsight.interfaces.Priceable;

//implements from Priceable interface, any subclass must have the getPrice and toString
public abstract class Item implements Priceable {
    @Override
    public abstract double getPrice();

    @Override
    public abstract String toString();
}
