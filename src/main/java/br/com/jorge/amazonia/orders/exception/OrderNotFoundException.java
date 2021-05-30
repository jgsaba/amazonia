package br.com.jorge.amazonia.orders.exception;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(){
        super("Given order was not found");
    }
}
