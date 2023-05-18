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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private GenerateUtil generateUtil;

    @Autowired
    private ValidateUtil validateUtil;

    @Autowired
    private FormatUtil formatUtil;


    public Transacao estorno(Long id){
      Optional<Transacao> transacaoOptional = transacaoRepository.findById(id);
      Transacao transacao = transacaoOptional.orElseThrow(() -> new ResourceNotFoundException(id));
      transacao.getDescricao().setStatus(DescricaoStatusEnum.CANCELADO);

      return formatTransacao(transacaoRepository.save(transacao));
    }

    public Transacao pagamento(Transacao transacao){
        validateUtil.validateCartao(transacao.getCartao());
        transacao.setId(null);
        transacao.getDescricao().setStatus(DescricaoStatusEnum.AUTORIZADO);
        transacao.getDescricao().setDataHora(Instant.now());
        transacao.getDescricao().setNsu(generateUtil.generateNsu());
        transacao.getDescricao().setCodigoAutorizacao(generateUtil.generateCodigoAutorizacao());
        transacao.getDescricao().setValor(formatUtil.formatValor(transacao.getDescricao().getValor()));

        return formatTransacao(transacaoRepository.save(transacao));
    }

    public List<Transacao> consultaTodos(){
        List<Transacao> transacaoList = transacaoRepository.findAll();

        for(Transacao transacao : transacaoList){
            transacao = formatTransacao(transacao);
        }

        return transacaoList;
    }

    public Transacao consulta(Long id){
        Optional<Transacao> transacao = transacaoRepository.findById(id);
        Transacao transacaoDb = transacao.orElseThrow(() -> new ResourceNotFoundException(id));

        return formatTransacao(transacaoDb);
    }

    public Transacao formatTransacao(Transacao transacao){
        transacao.setCartao(formatUtil.formatResponseCartao(transacao.getCartao()));

        return transacao;
    }
}
