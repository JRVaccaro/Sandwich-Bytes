package com.pluralsight.sandwichmodels;

public class Chips extends Item{
    private String size;
    private String flavor;

    public Chips(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
}
