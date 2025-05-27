package com.pluralsight.sandwichmodels;

public class Chips extends Item{
    private String flavor;

    public Chips(String flavor) {
        this.flavor = flavor;
    }


    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
    return 1.50;

    }
    @Override
    public String toString(){
        return String.format("Chips: " , flavor, getPrice());
    }
}
