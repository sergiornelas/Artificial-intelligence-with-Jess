package gov.sandia.jess.example.pricing.model;

import java.text.DecimalFormat;

import gov.sandia.jess.example.pricing.model.items.CreditCard;

public class OrderItem {
    private static DecimalFormat formatter = new DecimalFormat("0.00");
    private float price;
    private int partNumber;
    private String description;
    private int quantity;

    public OrderItem(String aDescription, int aPartNumber, float aPrice, int aQuantity) {
        partNumber = aPartNumber;
        description = aDescription;
        price = aPrice;
        quantity = aQuantity;
    }

    //Desde aqui ya estoy agarrando smarphones, computers y credit cards con la clase Object.
    public OrderItem(Object aDescription, int aPartNumber, float aPrice, int aQuantity) {
        partNumber = aPartNumber;
        description = aDescription.toString();
        price = aPrice;
        quantity = aQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public int getPartNumber() {
        return partNumber;
    }

    public float getTotal() {
        return price * quantity;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return quantity + " " + description + ": " + formatter.format(getTotal());
    }
}