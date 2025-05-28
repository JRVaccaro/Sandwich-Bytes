package com.pluralsight.sandwichmodels;

import java.util.ArrayList;
import java.util.List;

public class SignatureKnuckleSandwich  extends Sandwich {

    public SignatureKnuckleSandwich() {
        super(12, new Bread("Spicy Garlic"), true, knuckleSandwichToppings(), true, true);
    }

    private static List<Toppings> knuckleSandwichToppings() {
        List<Toppings> toppings = new ArrayList<>();

        toppings.add(new Meat("Spicy Salami"));
        toppings.add(new Cheese("Pepper Jack"));
        toppings.add(new Sauce("Sriracha"));
        toppings.add(new RegularTopping("Red Pepper Flakes"));

        return toppings;
    }
}

