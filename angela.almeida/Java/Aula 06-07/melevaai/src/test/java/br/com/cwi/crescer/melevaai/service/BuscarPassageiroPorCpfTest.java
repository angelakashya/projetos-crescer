package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.response.PassageiroResponse;
import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarPassageiroPorCpfTest {

    @InjectMocks
    BuscarPassageiroPorCpfService buscarPassageiroPorCpfService;

    @Mock
    PassageiroRepository passageiroRepository;

    @Test
    public void buscarPassageiroPorCpf() {

        String cpf = "03326073809";
        Passageiro passageiro = new Passageiro();

        Mockito.when(passageiroRepository.findByCpf(cpf))
                .thenReturn(Optional.of(passageiro));

        PassageiroResponse passageiroTest = buscarPassageiroPorCpfService.buscar(cpf);

        Assert.assertNotNull(passageiroTest);
        Assert.assertEquals(passageiroTest, passageiro);

    }
}
