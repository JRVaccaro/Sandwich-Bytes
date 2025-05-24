package com.pluralsight.sandwichmodels;

import java.util.List;

public class Sandwich extends Item  {
    private String size;
    private Bread bread;
    private boolean isToasted;
    private List<Toppings> toppings;
    private boolean hasExtraCheese;
    private boolean hasExtraMeat;

    @Override
    public double getPrice() {

    }
}
