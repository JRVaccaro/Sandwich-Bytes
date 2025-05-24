package com.pluralsight.sandwichmodels;

import java.util.List;

public class Sandwich extends Item  {
    private String size;
    private Bread bread;
    private boolean isToasted;
    private List<Toppings> toppings;
    private boolean hasExtraCheese;
    private boolean hasExtraMeat;

    public Sandwich(String size, Bread bread, boolean isToasted, List<Toppings> toppings, boolean hasExtraCheese, boolean hasExtraMeat) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppings = toppings;
        this.hasExtraCheese = hasExtraCheese;
        this.hasExtraMeat = hasExtraMeat;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(List<Toppings> toppings) {
        this.toppings = toppings;
    }

    public boolean isHasExtraCheese() {
        return hasExtraCheese;
    }

    public void setHasExtraCheese(boolean hasExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
    }

    public boolean isHasExtraMeat() {
        return hasExtraMeat;
    }

    public void setHasExtraMeat(boolean hasExtraMeat) {
        this.hasExtraMeat = hasExtraMeat;
    }

    @Override
    public double getPrice() {

    }
}
