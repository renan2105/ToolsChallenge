package com.toolschallenge.pagamento.resources;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @PostMapping(value = "/pagamento")
    public ResponseEntity<Transacao> pagamento(@RequestBody Transacao transacao){
        transacao = transacaoService.pagamento(transacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).body(transacao);
    }

    @GetMapping(value = "/consulta")
    public ResponseEntity<List<Transacao>> consultaTodos(){
        List<Transacao> transacaoList = transacaoService.consultaTodos();
        return ResponseEntity.ok().body(transacaoList);
    }

    @GetMapping(value = "/consulta/{id}")
    public ResponseEntity<Transacao> consulta(@PathVariable Long id){
        Transacao transacao = transacaoService.consulta(id);
        return ResponseEntity.ok().body(transacao);
    }
}
