package com.toolschallenge.pagamento.services;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;
import com.toolschallenge.pagamento.repositories.TransacaoRepository;
import com.toolschallenge.pagamento.services.exceptions.ResourceNotFoundException;
import com.toolschallenge.pagamento.utils.GenerateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TransacaoService {

    @Autowired
    private GenerateUtils generateUtils;

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao estorno(Long id){
      Optional<Transacao> transacaoOptional = transacaoRepository.findById(id);
      Transacao transacao = transacaoOptional.orElseThrow(() -> new ResourceNotFoundException(id));
      transacao.getDescricao().setStatus(DescricaoStatusEnum.CANCELADO);
      transacao = transacaoRepository.save(transacao);
      return transacao;
    }

    public Transacao pagamento(Transacao transacao){
        transacao.setId(null);
        transacao.getDescricao().setStatus(DescricaoStatusEnum.AUTORIZADO);
        transacao.getDescricao().setDataHora(Instant.now());
        transacao.getDescricao().setNsu(generateUtils.generateNsu());
        transacao.getDescricao().setCodigoAutorizacao(generateUtils.generateCodigoAutorizacao());
        return transacaoRepository.save(transacao);
    }

    public List<Transacao> consultaTodos(){
        return transacaoRepository.findAll();
    }

    public Transacao consulta(Long id){
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        return transacao.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
