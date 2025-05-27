package com.pluralsight.orders;

import com.pluralsight.sandwichmodels.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
private Order order;
private LocalDateTime timestamp;

    public Receipt(Order order) {
        this.order = order;
        this.timestamp = LocalDateTime.now();
    }
    public String generateReceiptText(){
        StringBuilder sb = new StringBuilder();


        //Header
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sb.append("--- Receipt ---\n");
        sb.append(timestamp.format(formatter));

        //need to list items and prices
        for (Item item : order.getItems()){
            // think i should make to String methods? sb.append()
        }
    }
}
