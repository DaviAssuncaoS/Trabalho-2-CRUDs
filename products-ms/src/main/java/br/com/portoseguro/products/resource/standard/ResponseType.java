package br.com.portoseguro.products.resource.standard;

public enum ResponseType {

    SUCCESS("Sucesso"),
    WARNING("Advertência"),
    ERROR("Erro");

    private final String text;
    ResponseType(String text){
        this.text = text;
    }
}