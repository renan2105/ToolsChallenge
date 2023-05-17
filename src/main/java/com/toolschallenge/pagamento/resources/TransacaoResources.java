package com.toolschallenge.pagamento.resources;

import com.toolschallenge.pagamento.entities.Transacao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoResources {
    @GetMapping
    public ResponseEntity<Transacao> findAll(){
        Transacao transacao = new Transacao(1L, "cartao");
        return ResponseEntity.ok().body(transacao);
    }

}
