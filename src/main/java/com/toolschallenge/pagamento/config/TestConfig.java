package com.toolschallenge.pagamento.config;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TransacaoRepository transacaoRepository;


    @Override
    public void run(String... args) throws Exception {

        Transacao transacaoTest = new Transacao(null, "cartao1");

        transacaoRepository.save(transacaoTest);

    }
}
