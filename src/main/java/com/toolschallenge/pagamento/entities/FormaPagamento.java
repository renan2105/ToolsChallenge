package com.toolschallenge.pagamento.entities;

import com.toolschallenge.pagamento.entities.enums.FormaPagamentoTipoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FormaPagamento {


    @NotNull(message = "Tipo do pagamento não pode ser nulo.")
    private Integer tipo;

    @NotNull(message = "Quantidade de parcelas não pode ser nulo.")
    private Integer parcelas;


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
}
