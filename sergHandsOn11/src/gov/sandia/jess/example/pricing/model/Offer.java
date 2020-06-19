package gov.sandia.jess.example.pricing.model;

import java.text.DecimalFormat;

public class Offer {
    private float amount;
    private float VALES;
    private final String description;
    
    private static DecimalFormat FORMA2 = new DecimalFormat("$0");

    public Offer(String aDescription, float anAmount) {
        description = aDescription;
        amount = anAmount;
    }

    //sobrecarga para meses sin intereses
    public Offer(String aDescription, float anAmount, float aVALES) {
        description = aDescription;
        VALES = aVALES;
    }

        //sobrecarga para vales
    public Offer(String aDescription){
        description = aDescription;
    }
    
    public float getAmount() {
	return amount;
    }

    // EN CASO DE QUE SE REALICE LA PROMO DE LOS MESES SIN INTERESES, SOLO IMPŔIMIR EL EL MENSAJE.
    public String getDescription() {
	return description;
    }

    public String toString() {
        //CUANDO SE MUESTRE LA PROMOCIÓN, EVITAR QUE APAREZCA EL $0
        if (VALES > 0) {
            return description + ": " + FORMA2.format(Math.floor(VALES));
        }
        else {
            return description;
        }
    }
}