package com.toolschallenge.pagamento.services.exceptions;

public class ValidateException extends RuntimeException {

    public ValidateException(Object cartao){
        super("O cartão " + cartao + " é inválido.");
    }

}
