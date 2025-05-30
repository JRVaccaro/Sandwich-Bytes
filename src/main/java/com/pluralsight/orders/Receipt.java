package com.pluralsight.orders;

import com.pluralsight.sandwichmodels.Item;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
private Order order;
private LocalDateTime timestamp;

    //Constructor saves the order and sets the current time as timestamp
    public Receipt(Order order) {
        this.order = order;
        this.timestamp = LocalDateTime.now();
    }
    //Generates a formatted receipt text which has items, their prices, and total.
    public String generateReceiptText() {
        StringBuilder sb = new StringBuilder();

        double total = 0;


        //Header
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sb.append("--- Receipt ---\n");
        sb.append("Date: ").append(timestamp.format(formatter)).append("\n\n");

        //Listing items and prices
        int count = 1;
        for (Item item : order.getItems()) {
            sb.append(count ++).append(") ").append(item.toString()).append("\n");
            total += item.getPrice();

        }
        //Appending total amount to receipt
        sb.append("\nTotal: $").append(String.format("%.2f", total)).append("\n");

        sb.append("\nThanks for biting into something great at Sandwich Bytes!\n");
        sb.append("See you next crunch!\uD83E\uDD6A\n");
        sb.append("-----------------------\n");

        //Return the final receipt text
        return sb.toString();
    }
    //Saving receipt to a file inside receipts folder
    public void saveReceiptToFile(){
        //Format filename using date and time
        DateTimeFormatter fileFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String filename = "receipts/" + timestamp.format(fileFormatter) + ".txt";
        try {
            //Writing the receipt txt to file
            FileWriter writer = new FileWriter(filename);
            writer.write(generateReceiptText());
            writer.close();

        } catch (IOException e) {
            System.out.println("Failed to create receipt");
        }


    }
}
