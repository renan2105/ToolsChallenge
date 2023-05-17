package com.toolschallenge.pagamento.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;

public class Descricao {
    @NotEmpty(message = "Valor deve ser informado.")
    private String valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
    private Instant dataHora;

    @NotEmpty(message = "Nome do estabelecimento deve ser informado.")
    private String estabelecimento;

    private String nsu;

    private String codigoAutorizacao;

    private Integer status;


    public Descricao() {
    }

    public Descricao(String valor, Instant dataHora, String estabelecimento, String nsu, String codigoAutorizacao, DescricaoStatusEnum status) {
        this.valor = valor;
        this.dataHora = dataHora;
        this.estabelecimento = estabelecimento;
        this.nsu = nsu;
        this.codigoAutorizacao = codigoAutorizacao;
        setStatus(status);
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getNsu() {
        return nsu;
    }

    public void setNsu(String nsu) {
        this.nsu = nsu;
    }

    public String getCodigoAutorizacao() {
        return codigoAutorizacao;
    }

    public void setCodigoAutorizacao(String codigoAutorizacao) {
        this.codigoAutorizacao = codigoAutorizacao;
    }

    public DescricaoStatusEnum getStatus() {
        return DescricaoStatusEnum.valueOf(status);
    }

    public void setStatus(DescricaoStatusEnum status) {
        if(status != null)
            this.status = status.getCode();
    }
}
