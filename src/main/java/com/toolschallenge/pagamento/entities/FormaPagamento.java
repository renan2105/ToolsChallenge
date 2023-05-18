package com.toolschallenge.pagamento.entities;

import com.toolschallenge.pagamento.entities.enums.FormaPagamentoTipoEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FormaPagamento {

    @NotBlank(message = "Tipo de pagamento deve ser informado.")
    private Integer tipo;

    @NotBlank(message = "Parcelas deve ser informado.")
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
