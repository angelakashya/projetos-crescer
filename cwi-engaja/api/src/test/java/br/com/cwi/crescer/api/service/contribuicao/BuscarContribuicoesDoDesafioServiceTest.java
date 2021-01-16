package br.com.cwi.crescer.api.service.contribuicao;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioUsuarioContribuicao;
import br.com.cwi.crescer.api.repository.DesafioUsuarioContribuicaoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarContribuicoesDoDesafioServiceTest {

    @InjectMocks
    BuscarContribuicoesDoDesafioService tested;

    @Mock
    DesafioUsuarioContribuicaoRepository repository;

    @Test
    public void deveBuscarContribuicoesComSucesso() {
        List<DesafioUsuarioContribuicao> contribuicoes = new ArrayList<>();
        Desafio desafio = new Desafio();

        Mockito.when(repository.findByDesafio(desafio)).thenReturn(Optional.of(contribuicoes));

        List<DesafioUsuarioContribuicao> result = tested.buscar(desafio);

        Mockito.verify(repository).findByDesafio(desafio);

        Assert.assertNotNull(result);
    }

    @Test(expected = ResponseStatusException.class)
    public void deveLancarExcecaoQuandoNaoEncontrarNada() {
        Desafio desafio = new Desafio();

        Mockito.when(repository.findByDesafio(desafio)).thenReturn(Optional.empty());

        try{
            tested.buscar(desafio);
        }catch(ResponseStatusException e){
            Mockito.verify(repository).findByDesafio(desafio);
            Assert.assertEquals("Algo deu errado ao buscar as contribuições do desafio.",
                    e.getReason());

            throw e;
        }




    }
}