package com.solidprinciples.singleresponsibility;

/**
 * Every class should perform only 1 responsibility.
 * Every class should have at most 1 reason to change.
 */
public class SingleResponsibilityPrincipleImpl {
    public static void main(String[] args) {
        Marker marker = new Marker(10, "Bloom", "Natraj", "white");
        Invoice invoice = new Invoice(marker, 10);
        System.out.println(invoice.calculatePrice());
        //Responsibilities are shifted to new class, now every class has only 1 reason to change.
        InvoiceDAO invoiceDao = new InvoiceDAO();
        invoiceDao.saveToDB(invoice);
        InvoicePrint invoicePrint = new InvoicePrint();
        invoicePrint.print(invoice);
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

class InvoiceDAO {
    public void saveToDB(Invoice invoice) {
        //Saving to DB logic
    }
}

class InvoicePrint {
    public void print(Invoice invoice) {
        //Printing logic
    }
}

/*
Now here comes another issue, what if we want to save Invoice in File as well along with
saving in DB.
 */
