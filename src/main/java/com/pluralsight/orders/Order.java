package com.pluralsight.orders;

import com.pluralsight.sandwichmodels.Item;

import java.util.ArrayList;
import java.util.List;

public class Order {
    //List which stores all items, (sandwiches, drinks, chips)
    private List<Item> items;

    public Order() {
        //start with an empty order
        this.items = new ArrayList<>();
    }

    //Returning the list of items in order
    public List<Item> getItems() {
        return items;
    }
    //Adding an item to the order
    public void addItem(Item item){
        items.add(item);
    }
    //Clears all items from order if user wants to cancel order
    public void clearOrder(){
        items.clear();
    }

    //Calculating and returning the total price of the order
    public double getTotalPrice(){
        double total = 0;
        for (Item item : items){
            total += item.getPrice();
        }
        return total;
}
}
