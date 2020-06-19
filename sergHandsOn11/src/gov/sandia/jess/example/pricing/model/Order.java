package gov.sandia.jess.example.pricing.model;

//sergio
import gov.sandia.jess.example.pricing.model.Computer;
import gov.sandia.jess.example.pricing.model.CreditCard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Order {
    private List items;
    private float total;
    private Customer customer;
    //se agrega 
    private CreditCard TARJETA_CREDITO;
    
    public Order(Collection theItems, Customer aCustomer) {
        items = new ArrayList(theItems);
        for (Iterator it = items.iterator(); it.hasNext();) {
            OrderItem item = (OrderItem) it.next();
            total += item.getTotal();
        }
        customer = aCustomer;
    }

    //tarjeta de credito
    public Order(Collection theItems, Customer aCustomer, CreditCard aCreditCard) {
        items = new ArrayList(theItems);
        for (Iterator it = items.iterator(); it.hasNext();) {
            OrderItem item = (OrderItem) it.next();
            total += item.getTotal();
        }
        customer = aCustomer;
        //tarjeta de credito
        TARJETA_CREDITO = aCreditCard;
    }
    
    public Iterator getItems() {
        return items.iterator();
    }
    
    public float getTotal() {
    	return total;
    }
    
    public Customer getCustomer() {
	    return customer;
    }

    //tarjeta de credito
    public CreditCard getCreditCard() {
	    return TARJETA_CREDITO;
    }
}