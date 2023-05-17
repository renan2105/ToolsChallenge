package com.toolschallenge.pagamento.entities;

import com.toolschallenge.pagamento.entities.enums.FormaPagamentoTipoEnum;
import jakarta.validation.constraints.NotEmpty;

public class FormaPagamento {

    @NotEmpty(message = "Tipo de pagamento deve ser informado.")
    private Integer tipo;

    @NotEmpty(message = "Parcelas deve ser informado.")
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
