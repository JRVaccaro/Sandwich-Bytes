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

    public Receipt(Order order) {
        this.order = order;
        this.timestamp = LocalDateTime.now();
    }
    public String generateReceiptText() {
        StringBuilder sb = new StringBuilder();

        double total = 0;


        //Header
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        sb.append("--- Receipt ---\n");
        sb.append(timestamp.format(formatter));

        //Listing items and prices
        for (Item item : order.getItems()) {
            sb.append(item.toString()).append("\n");
            total += item.getPrice();

        }
        sb.append("Total: $").append(String.format("%.2f", total));
        return sb.toString();
    }
    public void saveReceiptToFile(){
        DateTimeFormatter fileFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String filename = "receipts/" + timestamp.format(fileFormatter) + ".txt";
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(generateReceiptText());
            writer.close();

        } catch (IOException e) {
            System.out.println("Failed to create receipt");
        }


    }
}
