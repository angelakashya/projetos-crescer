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
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarOpcaoContribuicaoServiceTest {

    @InjectMocks
    BuscarOpcaoContribuicaoService tested;

    @Mock
    DesafioOpcaoContribuicaoRepository repository;

    @Test
    public void deveBuscarOpcaoComSucesso() {
        Desafio desafio = new Desafio();
        String contribuicao = "10";
        DesafioOpcaoContribuicao opcaoContribuicao = new DesafioOpcaoContribuicao();
        opcaoContribuicao.setContribuicao(contribuicao);

        Mockito.when(repository.findByDesafioAndContribuicao(desafio, contribuicao))
                .thenReturn(Optional.of(opcaoContribuicao));

        DesafioOpcaoContribuicao result = tested.buscar(desafio, contribuicao);

        Mockito.verify(repository).findByDesafioAndContribuicao(desafio, contribuicao);

        Assert.assertNotNull(result);
        Assert.assertEquals(contribuicao, result.getContribuicao());
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoAoTentarBuscarContribuicaoInvalida() {
        Desafio desafio = new Desafio();
        String contribuicao = "10";

        Mockito.when(repository.findByDesafioAndContribuicao(desafio, contribuicao))
                .thenReturn(Optional.empty());

        try{
            tested.buscar(desafio, contribuicao);
        }catch(ResponseStatusException e){
            Mockito.verify(repository).findByDesafioAndContribuicao(desafio, contribuicao);

            Assert.assertEquals("Contribuição selecionada é inválida.", e.getReason());

            throw e;
        }
    }
}