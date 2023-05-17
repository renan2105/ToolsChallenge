package com.toolschallenge.pagamento.services;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;
import com.toolschallenge.pagamento.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao estorno(Long id){
      Optional<Transacao> transacao = transacaoRepository.findById(id);
      return transacao.get();
    }

    public Transacao pagamento(Transacao transacao){
        transacao.getDescricao().setStatus(DescricaoStatusEnum.AUTORIZADO);
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> consultaTodos(){
        return transacaoRepository.findAll();
    }

    public Transacao consulta(Long id){
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        return transacao.get();
    }

}
