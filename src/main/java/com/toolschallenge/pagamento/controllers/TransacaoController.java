package com.toolschallenge.pagamento.controllers;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping(value = "/estorno/{id}")
    public ResponseEntity<Transacao> estorno(@PathVariable Long id){
        Transacao transacao = transacaoService.estorno(id);
        return ResponseEntity.ok().body(transacao);
    }

    @PostMapping(value = "/pagamento")
    public ResponseEntity<Transacao> pagamento(@Validated @RequestBody Transacao transacao){
        transacao = transacaoService.pagamento(transacao);
        return ResponseEntity.created(URI.create("/transacao/consulta/" + transacao.getId())).body(transacao);
    }

    @GetMapping(value = "/consulta")
    public ResponseEntity<List<Transacao>> consultaTodos(){
        List<Transacao> transacaoList = transacaoService.ListAllTransacao();
        return ResponseEntity.ok().body(transacaoList);
    }

    @GetMapping(value = "/consulta/{id}")
    public ResponseEntity<Transacao> consulta(@PathVariable Long id){
        Transacao transacao = transacaoService.findTransacaoById(id);
        return ResponseEntity.ok().body(transacao);
    }
}
