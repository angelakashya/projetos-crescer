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

@RunWith(MockitoJUnitRunner.class)
public class DataLimiteCriacaoValidatorTest {

    @InjectMocks
    DataLimiteCriacaoValidator tested;

    @Mock
    Clock clock;

    Clock fixedClock;

    Desafio desafio;

    @Before
    public void setup() {
        fixedClock = Clock.fixed(LocalDate.of(2020, 12, 12).atStartOfDay(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
        Mockito.doReturn(fixedClock.instant()).when(clock).instant();
        Mockito.doReturn(fixedClock.getZone()).when(clock).getZone();
        desafio = new Desafio();
    }

    @Test
    public void deveValidarComSucessoQuandoDataLimiteForAposDataAtual() {

        desafio.setDataLimite(LocalDate.of(2021, 1, 10));


        tested.validar(desafio);

    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoDataLimiteForAposDataAtual() {


        desafio.setDataLimite(LocalDate.of(2020, 12, 11));

        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e) {
            Assert.assertEquals("Data limite informada deve ser após a data de hoje.", e.getReason());

            throw e;
        }
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoDataLimiteForADataAtual() {


        desafio.setDataLimite(LocalDate.of(2020, 12, 12));


        try{
            tested.validar(desafio);
        }catch(ResponseStatusException e) {
            Assert.assertEquals("Data limite informada deve ser após a data de hoje.", e.getReason());

            throw e;
        }
    }

    @Test
    public void deveValidarComSucessoQuandoDataLimiteForNula() {
        tested.validar(desafio);
    }
}