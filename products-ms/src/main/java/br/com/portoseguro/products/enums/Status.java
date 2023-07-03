package br.com.portoseguro.products.enums;

public enum Status {

    ATIVO("Ativo"),
    DESATIVADO("Desativado");

    private final String text;
    Status(String text){
        this.text = text;
    }
}
