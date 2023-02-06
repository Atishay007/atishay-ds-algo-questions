package com.solidprinciples.openclosed;

/**
 * Class should extend the behavior and not change it.
 */
public class OpenClosedPrinciple {
    public static void main(String[] args) {

    }
}

class Marker {
    private int price;
    private String name;
    private String brand;
    private String color;

    public Marker(int price, String name, String brand, String color) {
        this.price = price;
        this.name = name;
        this.brand = brand;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

/*
Here Invoice is doing multiple things, SR -> says that the class should have
only 1 reason to change, so we will keep calculatePrice() responsibility here
and will move other responsibility.
 */
class Invoice {
    private Marker marker;
    private int qty;

    public Invoice(Marker marker, int qty) {
        this.marker = marker;
        this.qty = qty;
    }

    public long calculatePrice() {
        return marker.getPrice() * qty;
    }

    /*
    public void saveToDB() {
        //Saving to DB logic
    }
     */

    /*
    public void print() {
        //Printing logic
    }
     */
}

/**
 * Here we have created interface the class can opened for extension but
 * closed for modification, we can create multiple Invoice saving functionalities
 * but we are extending this functionality from InvoiceSaver interface.
 */
class InvoiceSaveToDB implements InvoiceSaver {
    @Override
    public void saveInvoice(Invoice invoice) {
        //Saving to DB logic
    }
}

class InvoiceSaveToFile implements InvoiceSaver {
    @Override
    public void saveInvoice(Invoice invoice) {
        //Saving to File logic
    }
}

class InvoicePrint implements InvoicePrintable {
    public void print(Invoice invoice) {
        //Printing logic
    }
}

