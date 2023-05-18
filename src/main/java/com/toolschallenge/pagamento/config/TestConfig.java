package com.toolschallenge.pagamento.config;

import com.toolschallenge.pagamento.entities.Descricao;
import com.toolschallenge.pagamento.entities.FormaPagamento;
import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;
import com.toolschallenge.pagamento.entities.enums.FormaPagamentoTipoEnum;
import com.toolschallenge.pagamento.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TransacaoRepository transacaoRepository;


    @Override
    public void run(String... args) throws Exception {

        Transacao transacaoTest = new Transacao(null, "4444000000001234", new Descricao("500.50", Instant.now(), "PetShop Mundo cão",
                "1234567890", "123456789", DescricaoStatusEnum.AUTORIZADO), new FormaPagamento(FormaPagamentoTipoEnum.AVISTA, 1));

        transacaoRepository.save(transacaoTest);

    }
}
