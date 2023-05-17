package com.toolschallenge.pagamento.utils;

import com.toolschallenge.pagamento.services.exceptions.ValidateException;
import org.springframework.stereotype.Component;

@Component
public class ValidateUtil {

    public void validateCartao(String cartao){

        String formatedCartao = cartao.replaceAll("[^0-9]+", "");
        if(formatedCartao.length() < 16)
            throw new ValidateException(cartao);
    }

}
