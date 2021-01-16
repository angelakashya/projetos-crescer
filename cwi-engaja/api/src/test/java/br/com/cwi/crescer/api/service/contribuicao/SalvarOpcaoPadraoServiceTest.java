package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioOpcaoContribuicao;
import br.com.cwi.crescer.api.repository.DesafioOpcaoContribuicaoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SalvarOpcaoPadraoServiceTest {

    @InjectMocks
    SalvarOpcaoPadraoService tested;

    @Mock
    DesafioOpcaoContribuicaoRepository repository;

    @Test
    public void deveSalvarOpcaoPadraoComSucesso() {

        Desafio desafio = new Desafio();

        DesafioOpcaoContribuicao result = tested.salvar(desafio);

        Mockito.verify(repository).save(result);

        Assert.assertEquals(desafio, result.getDesafio());
        Assert.assertEquals(DesafioOpcaoContribuicao.CONTRIBUICAO_PADRAO, result.getContribuicao());
    }
}