package com.toolschallenge.pagamento.entities;

import com.toolschallenge.pagamento.entities.enums.FormaPagamentoTipoEnum;

public class FormaPagamento {

    private Integer tipo;

    private Integer parcelas;


    public FormaPagamento() {
    }

    public FormaPagamento(FormaPagamentoTipoEnum tipo, Integer parcelas) {
        setTipo(tipo);
        this.parcelas = parcelas;
    }


    public FormaPagamentoTipoEnum getTipo() {
        return FormaPagamentoTipoEnum.valueOf(tipo);
    }

    public void setTipo(FormaPagamentoTipoEnum tipo) {
        if(tipo != null)
            this.tipo = tipo.getCode();
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }
}
