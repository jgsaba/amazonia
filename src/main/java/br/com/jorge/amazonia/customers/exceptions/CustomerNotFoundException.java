package br.com.jorge.amazonia.customers.exceptions;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException() {
        super("Customer not found");
    }
}
