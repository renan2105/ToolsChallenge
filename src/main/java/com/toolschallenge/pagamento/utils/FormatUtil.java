package com.toolschallenge.pagamento.utils;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

@Component
public class FormatUtil {

  Locale localeBR = new Locale("pt","BR");
  NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeBR);
  public String formatValor(String valor){

    if(valor.contains(",")) {
      valor = valor.replaceAll("[^0-9]+", "");
      StringBuilder stringBuilder = new StringBuilder(valor);
      valor = stringBuilder.insert(valor.length() - 2, '.').toString();
    } else {
      valor = valor.replaceAll("[^0-9]+", "");
    }

    return numberFormat.format(Double.parseDouble(valor));

  }


}
