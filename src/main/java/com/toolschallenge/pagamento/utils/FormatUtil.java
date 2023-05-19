package com.toolschallenge.pagamento.utils;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

@Component
public class FormatUtil {

  private static final Locale localeBR = new Locale("pt","BR");
  private static final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeBR);
  public static String formatValor(String valor){

    if(valor.contains(",")) {
      valor = valor.replaceAll("[^0-9]+", "");
      StringBuilder stringBuilder = new StringBuilder(valor);
      valor = stringBuilder.insert(valor.length() - 2, '.').toString();
    } else {
      valor = valor.replaceAll("[^0-9]+", "");
    }

    return numberFormat.format(Double.parseDouble(valor));

  }

  public static  String formatResponseCartao(String cartao){

    return cartao.substring(0,4) + "********" + cartao.substring(10,14);

  }


}
