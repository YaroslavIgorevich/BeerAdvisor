package com.beerapp.model;

import java.util.Arrays;
import java.util.List;

public class BeerExpert {
    public List getBrands(String color) {
        if (color.equals("amber")) {
            return Arrays.asList("Jack Amber", "Red Moose");
        } else {
            return Arrays.asList("Jail Pale Ale", "Gout Stout");
        }
    }
}
