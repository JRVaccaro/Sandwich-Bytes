package com.pluralsight.sandwichmodels;

public class Drink extends Item{
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
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
        double basePrice;

        //Change size to lowercase to handle case-insensitive matching
        switch (size.toLowerCase()){
            case "small":
                basePrice = 2.00;
                break;

            case "medium":
                basePrice = 2.50;
                break;

            case "large":
                basePrice = 3.00;
                break;

            default:
                //throw exception if size not valid
                throw new IllegalStateException("Invalid drink size.");
        }

        return basePrice;
    }
}
