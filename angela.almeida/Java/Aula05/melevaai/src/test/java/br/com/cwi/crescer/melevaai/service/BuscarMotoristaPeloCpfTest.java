package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.controller.response.MotoristaResponse;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarMotoristaPeloCpfTest {

    @InjectMocks
    BuscarMotoristaPorCpfService buscarMotoristaPorCpfService;

    @Mock
    MotoristaRepository motoristaRepository;

    @Test
    public void buscarMotoristaPeloCPFCorretamente() {

        String cpf = "03326073809";
        Motorista motorista = new Motorista();

        Mockito.when(motoristaRepository.findByCpf(cpf))
                .thenReturn(Optional.of(motorista));

        MotoristaResponse motoristaTest = buscarMotoristaPorCpfService.buscar(cpf);

        Assert.assertNotNull(motoristaTest);
        Assert.assertEquals(motoristaTest, motorista);

        Mockito.verify(motoristaRepository).findByCpf(cpf);
    }

}
