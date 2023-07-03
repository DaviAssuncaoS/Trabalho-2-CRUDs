package br.com.portoseguro.products.enums;

public enum UnitMeasurement {

    QUILOGRAMA("Quilograma"),
    LITRO("Litro"),
    UNIDADE("Unidade");

    private final String text;

    UnitMeasurement(String text){
        this.text = text;
    }
}
