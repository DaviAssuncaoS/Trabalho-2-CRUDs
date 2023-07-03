package br.com.portoseguro.products.enums;

public enum ProductType {

    VESTUARIO("Vestuário"),
    ALIMENTACAO("Alimentação"),
    ELETRONICO("Eletrônico");

    private final String text;

    ProductType(String text){
        this.text = text;
    }
}
