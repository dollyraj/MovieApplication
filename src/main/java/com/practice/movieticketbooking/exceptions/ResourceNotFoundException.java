package com.practice.movieticketbooking.exceptions;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName,String fieldName,int fieldValue) {
        super(String.format("%s not found with %s : %d",resourceName,fieldName,fieldValue));
    }

    public ResourceNotFoundException(String resourceName,String fieldName,String fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
    }
    public ResourceNotFoundException(String fieldValue) {
        super(fieldValue);
    }

}
