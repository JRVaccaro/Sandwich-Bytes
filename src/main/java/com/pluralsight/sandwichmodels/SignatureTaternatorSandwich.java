package com.pluralsight.sandwichmodels;

import java.util.ArrayList;
import java.util.List;

public class SignatureTaternatorSandwich extends Sandwich{
    public SignatureTaternatorSandwich() {
        super(12, new Bread("Potato bread"), true, taternatorToppings(), false, false);
    }
    private static List<Toppings> taternatorToppings(){
        List<Toppings> toppings = new ArrayList<>();
        toppings.add(new Meat("Bacon"));
        toppings.add(new Cheese("Pepper Jack"));
        toppings.add(new RegularTopping("Tater Tots"));
        toppings.add(new Sauce("Buffalo"));

        return toppings;


    }

    @Override
    public double getPrice() {
        return 14.00;
    }
}
