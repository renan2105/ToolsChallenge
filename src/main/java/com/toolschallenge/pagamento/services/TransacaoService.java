package com.toolschallenge.pagamento.services;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;
import com.toolschallenge.pagamento.repositories.TransacaoRepository;
import com.toolschallenge.pagamento.services.exceptions.ResourceNotFoundException;
import com.toolschallenge.pagamento.utils.FormatUtil;
import com.toolschallenge.pagamento.utils.GenerateUtil;
import com.toolschallenge.pagamento.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;


    public Transacao estorno(Long id){
      Optional<Transacao> transacaoOptional = transacaoRepository.findById(id);
      Transacao transacao = transacaoOptional.orElseThrow(() -> new ResourceNotFoundException(id));
      transacao.getDescricao().setStatus(DescricaoStatusEnum.CANCELADO);

      return formatTransacao(updateTransacao(transacao));
    }

    public Transacao pagamento(Transacao transacao){
        ValidateUtil.validateCartao(transacao.getCartao());
        transacao.getDescricao().setStatus(DescricaoStatusEnum.AUTORIZADO);
        transacao.getDescricao().setDataHora(Instant.now());
        transacao.getDescricao().setNsu(GenerateUtil.generateNsu());
        transacao.getDescricao().setCodigoAutorizacao(GenerateUtil.generateCodigoAutorizacao());
        transacao.getDescricao().setValor(FormatUtil.formatValor(transacao.getDescricao().getValor()));

        return formatTransacao(insertTransacao(transacao));
    }

    private Transacao insertTransacao(Transacao transacao){
        transacao.setId(null);
        return transacaoRepository.save(transacao);
    }

    private Transacao updateTransacao(Transacao transacao){
        return transacaoRepository.save(transacao);
    }


    public List<Transacao> ListAllTransacao(){
        List<Transacao> transacaoList = transacaoRepository.findAll();

        for(Transacao transacao : transacaoList){
            transacao = formatTransacao(transacao);
        }

        return transacaoList;
    }

    public Transacao findTransacaoById(Long id){
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        Transacao transacaoDb = transacao.orElseThrow(() -> new ResourceNotFoundException(id));

        return formatTransacao(transacaoDb);
    }
    private Transacao formatTransacao(Transacao transacao){
        transacao.setCartao(FormatUtil.formatResponseCartao(transacao.getCartao()));

        return transacao;
    }
}
