package com.toolschallenge.pagamento.services;

import com.toolschallenge.pagamento.entities.Transacao;
import com.toolschallenge.pagamento.repositories.TransacaoRepository;
import com.toolschallenge.pagamento.services.exceptions.ResourceNotFoundException;
import com.toolschallenge.pagamento.services.exceptions.ValidateException;
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
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class TransacaoServiceTest {

    @InjectMocks
    private TransacaoService transacaoService;

    @Mock
    private TransacaoRepository transacaoRepositoryMock;


    @BeforeEach
    void setup(){
        Transacao transacaoEstorno = TransacaoGenerateUtil.generateValidTransacao();
        BDDMockito.when(transacaoRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(transacaoEstorno));

        List<Transacao> transacaoConsultaTodos = List.of(TransacaoGenerateUtil.generateValidTransacao());
        BDDMockito.when(transacaoRepositoryMock.findAll()).thenReturn(transacaoConsultaTodos);

        Transacao transacaoConsulta = TransacaoGenerateUtil.generateValidTransacao();
        BDDMockito.when(transacaoRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(transacaoConsulta));

        Transacao transacaoPagamento = TransacaoGenerateUtil.generateValidTransacao();
        BDDMockito.when(transacaoRepositoryMock.save(ArgumentMatchers.any(Transacao.class))).thenReturn(transacaoPagamento);
    }

    @Test
    void estorno_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        Transacao transacaoResponse = transacaoService.estorno(1L);

        Assertions.assertThat(transacaoResponse).isNotNull();
        Assertions.assertThat(transacaoResponse.getId()).isEqualTo(expectedTransacao.getId());

    }

    @Test
    void estorno_Throws_ResourceNotFoundException(){

        BDDMockito.when(transacaoRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(ResourceNotFoundException.class)
                .isThrownBy(() -> transacaoService.estorno(1L));

    }

    @Test
    void pagamento_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        Transacao pagamentoResponse = transacaoService.pagamento(TransacaoGenerateUtil.generateValidTransacaoToSave());

        Assertions.assertThat(pagamentoResponse).isNotNull();
        Assertions.assertThat(pagamentoResponse.getId()).isEqualTo(expectedTransacao.getId());

    }

    @Test
    void pagamento_Throws_ValidateException(){

        Assertions.assertThatExceptionOfType(ValidateException.class)
                .isThrownBy(() -> transacaoService.pagamento(TransacaoGenerateUtil.generateInvalidCardTransacao()));

    }

    @Test
    void listAll_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        List<Transacao> consultaTodosResponse = transacaoService.ListAllTransacao();

        Assertions.assertThat(consultaTodosResponse).isNotEmpty();
        Assertions.assertThat(consultaTodosResponse.get(0).getId()).isEqualTo(expectedTransacao.getId());

    }

    @Test
    void findTransacaoById_Successful(){

        Transacao expectedTransacao = TransacaoGenerateUtil.generateValidTransacao();

        Transacao consultaResponse = transacaoService.findTransacaoById(1L);

        Assertions.assertThat(consultaResponse).isNotNull();
        Assertions.assertThat(consultaResponse.getId()).isEqualTo(expectedTransacao.getId());

    }

    @Test
    void findTransacaoById_Throws_ResourceNotFoundException(){

        BDDMockito.when(transacaoRepositoryMock.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(ResourceNotFoundException.class)
                .isThrownBy(() -> transacaoService.findTransacaoById(1L));

    }

}