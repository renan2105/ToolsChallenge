package com.toolschallenge.pagamento.repositories;

import com.toolschallenge.pagamento.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
