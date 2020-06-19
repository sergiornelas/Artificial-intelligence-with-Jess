package gov.sandia.jess.example.pricing.model;

public class Computer{
    private final String MODELO; // MCBOOK AIR
    private final String MARCA; // APPLE

    public Computer(String MODELO, String MARCA){
        this.MODELO = MODELO;
        this.MARCA = MARCA;
    }

    public String getModel(){
        return MODELO;
    }

    public String getBrand(){
        return MARCA;
    }

    
    @Override
    public String toString(){
        return MODELO + " DE LA MARCA " + MARCA;
    }
}