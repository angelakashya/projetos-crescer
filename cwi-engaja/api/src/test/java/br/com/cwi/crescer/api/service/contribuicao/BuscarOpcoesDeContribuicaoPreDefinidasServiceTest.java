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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BuscarOpcoesDeContribuicaoPreDefinidasServiceTest {

    @InjectMocks
    BuscarOpcoesDeContribuicaoPreDefinidasService buscarOpcoes;

    @Mock
    DesafioOpcaoContribuicaoRepository repository;

    @Test
    public void deveRetornarListaPopuladaQuandoDesafioTiverOpcaoPreDefinida() {

        Desafio desafio = new Desafio();
        List<DesafioOpcaoContribuicao> opcoes = new ArrayList<>();
        DesafioOpcaoContribuicao opcao = new DesafioOpcaoContribuicao();
        opcoes.add(opcao);

        Mockito.when(repository.findByDesafioAndContribuicaoNot(desafio, DesafioOpcaoContribuicao.CONTRIBUICAO_PADRAO))
                .thenReturn(Optional.of(opcoes));

        List<DesafioOpcaoContribuicao> result = buscarOpcoes.buscar(desafio);

        Mockito.verify(repository).findByDesafioAndContribuicaoNot(desafio, DesafioOpcaoContribuicao.CONTRIBUICAO_PADRAO);

        Assert.assertNotNull(result);
        Assert.assertEquals(opcoes.size(), result.size());
    }

    @Test
    public void deveRetornarListaVaziaQuandoDesafioNaoTiverOpcaoPreDefinida() {
        Desafio desafio = new Desafio();

        Mockito.when(repository.findByDesafioAndContribuicaoNot(desafio, DesafioOpcaoContribuicao.CONTRIBUICAO_PADRAO))
                .thenReturn(Optional.empty());

        List<DesafioOpcaoContribuicao> result = buscarOpcoes.buscar(desafio);

        Mockito.verify(repository).findByDesafioAndContribuicaoNot(desafio, DesafioOpcaoContribuicao.CONTRIBUICAO_PADRAO);

        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.size());
    }
}