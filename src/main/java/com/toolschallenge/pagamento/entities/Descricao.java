package com.toolschallenge.pagamento.entities;

import com.toolschallenge.pagamento.entities.enums.DescricaoStatusEnum;

import java.time.Instant;

public class Descricao {

    private String valor;

    private Instant dataHora;

    private String estabelecimento;

    private Integer nsu;

    private String codigoAutorizacao;

    private Integer status;


    public Descricao() {
    }

    public Descricao(String valor) {
        this.valor = valor;
    }

    public Descricao(String valor, Instant dataHora, String estabelecimento, Integer nsu, String codigoAutorizacao, DescricaoStatusEnum status) {
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

    public Integer getNsu() {
        return nsu;
    }

    public void setNsu(Integer nsu) {
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
