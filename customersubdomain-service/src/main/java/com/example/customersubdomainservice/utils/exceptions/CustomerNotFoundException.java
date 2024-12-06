package com.example.customersubdomainservice.utils.exceptions;


public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(){

    }
    public CustomerNotFoundException(String message){super(message);}
    public CustomerNotFoundException(Throwable cause){super(cause);}
    public CustomerNotFoundException(String message, Throwable cause){super(message,cause);}
}