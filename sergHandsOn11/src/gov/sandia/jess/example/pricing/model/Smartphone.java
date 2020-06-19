package gov.sandia.jess.example.pricing.model;

public class Smartphone{
    private final String MODELO; // IFON 11 Pro, NOTE 11
    private final String MARCA; // Apple, Samsung

    public Smartphone(String MODELO, String MARCA){
        this.MODELO = MODELO;
        this.MARCA = MARCA;
    }

    public String getMODELO(){
        return MODELO;
    }

    public String getMARCA(){
        return MARCA;
    }

    @Override
    public String toString(){
        return MODELO + " DE LA MARCA " +MARCA;
    }
}