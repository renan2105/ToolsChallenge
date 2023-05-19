package com.toolschallenge.pagamento.controllers;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.services.TransacaoService;
import com.toolschallenge.pagamento.utils.TransacaoGenerateUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class TransacaoControllerTest {

    @InjectMocks
    private TransacaoController transacaoController;

    @Mock
    private TransacaoService transacaoServiceMock;


    @BeforeEach
    void setup(){
        Transacao transacaoEstorno = TransacaoGenerateUtil.generateValidTransacao();
        BDDMockito.when(transacaoServiceMock.estorno(ArgumentMatchers.anyLong())).thenReturn(transacaoEstorno);

        List<Transacao> transacaoConsultaTodos = List.of(TransacaoGenerateUtil.generateValidTransacao());
        BDDMockito.when(transacaoServiceMock.ListAllTransacao()).thenReturn(transacaoConsultaTodos);

        Transacao transacaoConsulta = TransacaoGenerateUtil.generateValidTransacao();
        BDDMockito.when(transacaoServiceMock.findTransacaoById(ArgumentMatchers.anyLong())).thenReturn(transacaoConsulta);

        Transacao transacaoPagamento = TransacaoGenerateUtil.generateValidTransacao();
        BDDMockito.when(transacaoServiceMock.pagamento(ArgumentMatchers.any(Transacao.class))).thenReturn(transacaoPagamento);
    }

    @Test
    void estorno_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        Transacao transacaoResponse = transacaoController.estorno(1L).getBody();

        Assertions.assertThat(transacaoResponse).isNotNull();
        Assertions.assertThat(transacaoResponse.getId()).isEqualTo(expectedTransacao.getId());

    }

    @Test
    void pagamento_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        Transacao pagamentoResponse = transacaoController.pagamento(new Transacao()).getBody();

        Assertions.assertThat(pagamentoResponse).isNotNull();
        Assertions.assertThat(pagamentoResponse.getId()).isEqualTo(expectedTransacao.getId());

    }

    @Test
    void consultaTodos_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        List<Transacao> consultaTodosResponse = transacaoController.consultaTodos().getBody();

        Assertions.assertThat(consultaTodosResponse).isNotEmpty();
        Assertions.assertThat(consultaTodosResponse.get(0).getId()).isEqualTo(expectedTransacao.getId());

    }

    @Test
    void consulta_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        Transacao consultaResponse = transacaoController.consulta(1L).getBody();

        Assertions.assertThat(consultaResponse).isNotNull();
        Assertions.assertThat(consultaResponse.getId()).isEqualTo(expectedTransacao.getId());

    }

}