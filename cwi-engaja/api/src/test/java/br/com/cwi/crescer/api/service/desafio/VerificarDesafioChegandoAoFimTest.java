package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
public class VerificarDesafioChegandoAoFimTest {

    @InjectMocks
    VerificarDesafioChegandoAoFim tested;

    @Mock
    Clock clock;

    Clock fixedClock;

    Desafio desafio;

    @Before
    public void setup() {
        fixedClock = Clock.fixed(LocalDate.of(2020, 12, 12).atStartOfDay(ZoneId.systemDefault())
                .toInstant(), ZoneId.systemDefault());
        Mockito.doReturn(fixedClock.instant()).when(clock).instant();
        Mockito.doReturn(fixedClock.getZone()).when(clock).getZone();
        desafio = new Desafio();
    }

    @Test
    public void deveRetornarFalsoQuandoDesafioNaoTiverDataLimite() {

        boolean result = tested.isChegandoAoFim(desafio);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarFalsoQuandoFaltarMaisDeTresDias() {
        desafio.setDataLimite(LocalDate.of(2020, 12, 20));

        boolean result = tested.isChegandoAoFim(desafio);

        Assert.assertFalse(result);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoFaltarTresDias() {
        desafio.setDataLimite(LocalDate.of(2020, 12, 15));

        boolean result = tested.isChegandoAoFim(desafio);

        Assert.assertTrue(result);
    }

    @Test
    public void deveRetornarVerdadeiroQuandoFaltarMenosDeTresDias() {

        desafio.setDataLimite(LocalDate.of(2020, 12, 13));

        boolean result = tested.isChegandoAoFim(desafio);

        Assert.assertTrue(result);
    }
}