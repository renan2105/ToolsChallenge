package com.toolschallenge.pagamento.resources;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoResources {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping(value = "/estorno/{id}")
    public ResponseEntity<Transacao> estorno(@PathVariable Long id){
        Transacao transacao = transacaoService.estorno(id);
        return ResponseEntity.ok().body(transacao);
    }

}
