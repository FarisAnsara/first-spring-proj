package org.example.details;

import java.util.ArrayList;

public class Details {
    // Creating an object of ArrayList
    static ArrayList<Details> Data = new ArrayList<Details>();
    int number;
    String name;
    Details(int number, String name)
    {
        // This keyword refers
        // to parent instance itself
        this.number = number;
        this.name = name;
    }
}