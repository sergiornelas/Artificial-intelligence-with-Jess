package gov.sandia.jess.example.pricing.model;
//sergio
import gov.sandia.jess.example.pricing.model.Computer;

public class Customer {	
    private int orderCount;
    
    public Customer(int anOrderCount) {
	    orderCount = anOrderCount;
    }
    
    public int getOrderCount() {
	    return orderCount;
    }
}