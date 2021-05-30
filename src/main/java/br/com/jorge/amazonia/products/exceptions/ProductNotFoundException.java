package br.com.jorge.amazonia.products.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(){
        super("Was not found a product with the given identifier");
    }

    public ProductNotFoundException(String identifier){
        super( String.format("Was not found a product with identifier: %s", identifier));
    }
}
