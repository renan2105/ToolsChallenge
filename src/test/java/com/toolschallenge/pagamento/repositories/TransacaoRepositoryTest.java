package com.toolschallenge.pagamento.repositories;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.utils.TransacaoGenerateUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
class TransacaoRepositoryTest {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Test
    public void save_Transacao_Successful(){

        Transacao transacao = TransacaoGenerateUtil.generateValidTransacaoToSave();
        Transacao transacaoDb = this.transacaoRepository.save(transacao);

        Assertions.assertThat(transacaoDb).isNotNull();
        Assertions.assertThat(transacaoDb.getId()).isNotNull();
        Assertions.assertThat(transacaoDb.getCartao()).isEqualTo(transacao.getCartao());

    }

    @Test
    public void update_Transacao_Successful(){

        Transacao transacao = TransacaoGenerateUtil.generateValidTransacaoToSave();
        Transacao transacaoDb = this.transacaoRepository.save(transacao);

        String newCartao = "3333111111114321";
        transacaoDb.setCartao(newCartao);
        transacaoDb = this.transacaoRepository.save(transacao);

        Assertions.assertThat(transacaoDb).isNotNull();
        Assertions.assertThat(transacaoDb.getId()).isNotNull();
        Assertions.assertThat(transacaoDb.getCartao()).isEqualTo(newCartao);

    }

    @Test
    public void find_Transacao_ById_Successful(){

        Transacao transacao = TransacaoGenerateUtil.generateValidTransacaoToSave();
        Transacao transacaoDb = this.transacaoRepository.save(transacao);

        Long transacaoId = transacaoDb.getId();
        Optional<Transacao> transacaoFound = transacaoRepository.findById(transacaoId);

        Assertions.assertThat(transacaoFound).isNotNull();

    }

    @Test
    public void findAll_Transacao_Successful(){

        Transacao transacao = TransacaoGenerateUtil.generateValidTransacaoToSave();
        this.transacaoRepository.save(transacao);

        transacao.setCartao("3333111111114321");
        this.transacaoRepository.save(transacao);

        List<Transacao> transacaoList = transacaoRepository.findAll();

        Assertions.assertThat(transacaoList).isNotEmpty();

    }

}