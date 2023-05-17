package com.toolschallenge.pagamento.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
public class Transacao implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Cartão deve ser informado.")
    private String cartao;

    @Embedded
    private Descricao descricao;

    @Embedded
    private FormaPagamento formaPagamento;

    public Transacao() {
    }

    public Transacao(Long id, String cartao, Descricao descricao, FormaPagamento formaPagamento) {
        this.id = id;
        this.cartao = cartao;
        this.descricao = descricao;
        this.formaPagamento = formaPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
