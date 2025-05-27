package com.pluralsight.orders;

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }
}
