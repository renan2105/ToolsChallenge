package com.toolschallenge.pagamento.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException (Object id){
        super("Id " + id + " não encontrado.");
    }

}
