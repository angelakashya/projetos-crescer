package br.com.cwi.crescer.api.validator.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.web.server.ResponseStatusException;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DataLimiteDesafioValidatorTest {

    @InjectMocks
    DataLimiteDesafioValidator tested;

    @Mock
    Clock clock;

    Clock fixedClock;

    @Before
    public void setup() {
        fixedClock = Clock.fixed(LocalDate.of(2020, 12, 12).atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        Mockito.doReturn(fixedClock.instant()).when(clock).instant();
        Mockito.doReturn(fixedClock.getZone()).when(clock).getZone();
    }

    @Test
    public void deveValidarComSucessoQuandoDataLimiteForAposDataAtual() {

        Desafio desafio = new Desafio();
        desafio.setDataLimite(LocalDate.of(2021, 12, 12));

        tested.validar(desafio);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoDataLimiteForAntesDaDataAtual(){
        Desafio desafio = new Desafio();
        desafio.setDataLimite(LocalDate.of(2019, 12, 12));

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e){
            Assert.assertEquals("Data limite de contribuição já passou.", e.getReason());
            throw e;
        }

    }
}