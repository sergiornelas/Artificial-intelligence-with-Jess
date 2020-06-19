package catalog.model;

import java.sql.*;
import java.util.List;
//import java.util.*;
import java.text.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/* 
*  Java Hibernate - Model Class - Catalog.CatalogItem
*  
*/
@Entity
@Table(name = "CatalogItem")
public class CatalogItem {

    // fields
    @Id
    @GeneratedValue
    @Column(name = "partNumber")
    private int m_partNumber;

    @Column(name = "description", nullable = false)
    private String m_description;

    @Column(name = "price", nullable = false)
    private double m_price;

    @Column(name = "quantity", nullable = false)
    private int m_quantity;

    /**
     * Constructor
     * 
     * Example: CatalogItem myCatalogItem = new CatalogItem();
     */
    public CatalogItem() {
        // empty constructor
    }

    /**
     * Constructor
     * 
     * Example: CatalogItem myCatalogItem = new CatalogItem( val1, val2,.. );
     */
    public CatalogItem(int partNumber, String description, double price, int quantity) {
        this.setPartNumber(partNumber);
        this.setDescription(description);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    /**
     * Getters and Setters
     */

    public int getPartNumber() {
        return this.m_partNumber;
    }

    public void setPartNumber(int partNumber) {
        this.m_partNumber = partNumber;
    }

    public String getDescription() {
        return this.m_description;
    }

    public void setDescription(String description) {
        this.m_description = description;
    }

    public double getPrice() {
        return this.m_price;
    }

    public void setPrice(double price) {
        this.m_price = price;
    }

    public int getQuantity() {
        return this.m_quantity;
    }

    public void setQuantity(int quantity) {
        this.m_quantity = quantity;
    }

    /**
     * Methods
     */

    @Override
    public String toString() {
        return "";
    }

}