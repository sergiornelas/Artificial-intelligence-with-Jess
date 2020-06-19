package gov.sandia.jess.example.pricing.model;

public class CreditCard{
    
    private final String NOMBRE; // BANAMEX, LIVERPOOL VISA, BANCO AZTECA
    private final String CLASE; // bank issued o departamental
        
    public CreditCard(String NOMBRE, String CLASE){
        this.NOMBRE = NOMBRE;
        this.CLASE = CLASE;
    }

    
    public String getNOMBRE(){
        return NOMBRE;
    }

    public String getCLASE(){
        return CLASE;
    }

    @Override
    public String toString(){
        return NOMBRE + " by " + CLASE;
    }
}