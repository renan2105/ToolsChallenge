package com.toolschallenge.pagamento.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transacao implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Cartão não pode ser nulo ou vazio.")
    private String cartao;

    @Valid
    @Embedded
    private Descricao descricao;

    @Valid
    @Embedded
    private FormaPagamento formaPagamento;

}
