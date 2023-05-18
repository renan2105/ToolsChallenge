package com.toolschallenge.pagamento.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Descricao {
    @NotBlank(message = "Valor deve ser informado.")
    private String valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
    private Instant dataHora;

    @NotBlank(message = "Nome do estabelecimento deve ser informado.")
    private String estabelecimento;

    private String nsu;

    private String codigoAutorizacao;

    private Integer status;


    public Descricao(String valor, Instant dataHora, String estabelecimento, String nsu, String codigoAutorizacao, DescricaoStatusEnum status) {
        this.valor = valor;
        this.dataHora = dataHora;
        this.estabelecimento = estabelecimento;
        this.nsu = nsu;
        this.codigoAutorizacao = codigoAutorizacao;
        setStatus(status);
    }


    public DescricaoStatusEnum getStatus() {
        return DescricaoStatusEnum.valueOf(status);
    }

    public void setStatus(DescricaoStatusEnum status) {
        if(status != null)
            this.status = status.getCode();
    }
}
