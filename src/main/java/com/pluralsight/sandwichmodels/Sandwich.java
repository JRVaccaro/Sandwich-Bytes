package com.pluralsight.sandwichmodels;

import java.util.List;
import java.util.stream.Collectors;

public class Sandwich extends Item {
    private int size;
    private Bread bread;
    private boolean isToasted;
    private List<Toppings> toppings;
    private boolean hasExtraCheese;
    private boolean hasExtraMeat;

    public Sandwich(int size, Bread bread, boolean isToasted, List<Toppings> toppings, boolean hasExtraCheese, boolean hasExtraMeat) {
        this.size = size;
        this.bread = bread;
        this.isToasted = isToasted;
        this.toppings = toppings;
        this.hasExtraCheese = hasExtraCheese;
        this.hasExtraMeat = hasExtraMeat;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
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

    public boolean hasExtraCheese() {
        return hasExtraCheese;
    }

    public void setHasExtraCheese(boolean hasExtraCheese) {
        this.hasExtraCheese = hasExtraCheese;
    }

    public boolean hasExtraMeat() {
        return hasExtraMeat;
    }

    public void setHasExtraMeat(boolean hasExtraMeat) {
        this.hasExtraMeat = hasExtraMeat;
    }

    //Method that adds a new topping to the sandwich's topping list
    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    //Method to remove topping from sandwich's topping list by its type
    public boolean removeTopping(String type) {
        //Loop through topping list
        for (int i = 0; i < toppings.size(); i++ ){
            //checking if current topping type matches user input
            if (toppings.get(i).getType().equalsIgnoreCase(type)){
                //remove topping
                toppings.remove(i);

                 return true;
    }
}
        //if topping not found return false
        return false;
                }

    @Override
    public double getPrice() {
        double basePrice;

        //Set base price depending on sandwich size
        switch (size) {
            case 4:
                basePrice = 5.50;
                break;

            case 8:
                basePrice = 7.00;
                break;

            case 12:
                basePrice = 8.50;
                break;

            default:
                throw new IllegalStateException("Invalid sandwich size.");

        }
        //Add extra cost if sandwich has extra cheese
        if (hasExtraCheese) {


            switch (size) {
                case 4: //4 inch sandwich
                    basePrice += 0.30;
                    break;

                case 8: //8 inch sandwich
                    basePrice += 0.60;
                    break;

                case 12: // 12 inch sandwich
                    basePrice += 0.90;
                    break;
            }

        }
        //Add extra cost if sandwich has extra meat
        if (hasExtraMeat) {

            switch (size) {
                case 4: //4 inch sandwich
                    basePrice += 0.50;
                    break;

                case 8: // 8 inch sandwich
                    basePrice += 1.00;
                    break;

                case 12: //12 inch sandwich
                    basePrice += 1.50;
                    break;
            }
        }
        //Adds the prices of all other toppings that are in the sandwich
        for (Toppings topping : toppings) {

            //Checking if current topping is a Cheese object- then it would add size-based pricing
            if (topping instanceof Cheese) {

                switch (size) {
                    case 4: // 4 inch sandwich
                        basePrice += 0.75;
                        break;

                    case 8: //8 inch sandwich
                        basePrice += 1.50;
                        break;

                    case 12: //12 inch sandwich
                        basePrice += 2.25;
                }

            }
            //Checking if current topping is a Meat object- then it would add size-based pricing.
            else if (topping instanceof Meat) {

                switch (size){
                    case 4: //4 inch sandwich
                        basePrice += 1.00;
                        break;

                    case 8: //8 inch sandwich
                        basePrice += 2.00;
                        break;

                    case 12:
                        basePrice += 3.00;
                        break;

            }
        }
            else {
                basePrice += topping.getPrice();
            }
        }
                return basePrice;
            }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sandwich Size: ").append(size).append(" inch").append("\n")
                .append("Bread: ").append(bread.getType()).append("\n")
                .append("Toasted: ").append(isToasted ? "Yes" : "No").append("\n")
                .append("Extra Cheese: ").append(hasExtraCheese ? "Yes" : "No").append("\n")
                .append("Extra Meat: ").append(hasExtraMeat ? "Yes" : "No").append("\n")
                .append("Toppings: ");

        //If the toppings list is empty
        if (toppings.isEmpty()){
            sb.append("No toppings");

        } else {

            //If there are toppings, join their types into a string separated by commas
            String toppingsJoining = toppings.stream()
                    //convert each Toppings object to its type string
                    .map(Toppings ::getType)
                    // Join all topping type strings with delimiter ", " as separator
                    .collect(Collectors.joining(", "));

            sb.append(toppingsJoining);


            }
        sb.append("\n");

        return sb.toString();
    }
}
