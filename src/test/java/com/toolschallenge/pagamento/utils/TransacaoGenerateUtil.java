package com.toolschallenge.pagamento.utils;

import com.toolschallenge.pagamento.entities.Descricao;
import com.toolschallenge.pagamento.entities.FormaPagamento;
import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;
import com.toolschallenge.pagamento.entities.enums.FormaPagamentoTipoEnum;

import java.time.Instant;

public class TransacaoGenerateUtil {

    public static Transacao generateValidTransacaoToSave(){
        return new Transacao(null, "4444000000001234", new Descricao("500.50", Instant.now(), "PetShop Mundo cão",
                "1234567890", "123456789", DescricaoStatusEnum.AUTORIZADO), new FormaPagamento(FormaPagamentoTipoEnum.AVISTA, 1));
    }

    public static Transacao generateValidTransacao(){
        return new Transacao(1L, "4444000000001234", new Descricao("500.50", Instant.now(), "PetShop Mundo cão",
                "1234567890", "123456789", DescricaoStatusEnum.AUTORIZADO), new FormaPagamento(FormaPagamentoTipoEnum.AVISTA, 1));
    }

    public static Transacao generateInvalidCardTransacao(){
        return new Transacao(1L, "44441234", new Descricao("500.50", Instant.now(), "PetShop Mundo cão",
                "1234567890", "123456789", DescricaoStatusEnum.AUTORIZADO), new FormaPagamento(FormaPagamentoTipoEnum.AVISTA, 1));
    }



}
