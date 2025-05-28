package com.pluralsight.sandwichmodels;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BreadTest {

    @Test
    void getType() {
        Bread bread = new Bread("White");
       assertEquals("White", bread.getType());
    }
}