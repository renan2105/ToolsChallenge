package com.toolschallenge.pagamento.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GenerateUtil {

    public String generateNsu(){
        Random random = new Random();
        long nsu = random.nextLong(9999999999L);
        return Long.toString(nsu);
    }

    public String generateCodigoAutorizacao(){
        Random random = new Random();
        long nsu = random.nextLong(999999999L);
        return Long.toString(nsu);
    }

}
