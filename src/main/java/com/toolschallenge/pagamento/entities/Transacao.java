package com.toolschallenge.pagamento.entities;

import java.io.Serializable;

public class Transacao implements Serializable {

    private Long id;

    private String cartao;


    public Transacao() {
    }

    public Transacao(Long id, String cartao) {
        this.id = id;
        this.cartao = cartao;
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

}
