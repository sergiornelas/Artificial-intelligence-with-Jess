package gov.sandia.jess.example.pricing.model;

//sergio
import gov.sandia.jess.example.pricing.model.Computer;
import gov.sandia.jess.example.pricing.model.CreditCard;

public class CatalogItem {
    private String description;
    private int partNumber;
    private float price;

    public CatalogItem(String aDescription, int aPartNumber, float aPrice) {
	description = aDescription;
	partNumber = aPartNumber; //ID
	price = aPrice;
    }

    public CatalogItem(Object aDescription, int aPartNumber, float aPrice) {
	description = aDescription.toString();
	partNumber = aPartNumber;
	price = aPrice;
    }

    public int getPartNumber() {
	return partNumber;
    }
	
    public String getDescription() {
	return description;
    }
	
    public float getPrice() {
	return price;
    }
}
