package br.com.cwi.crescer.api.service.meta;

import br.com.cwi.crescer.api.controller.requestdto.DesafioRequest;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FiltrarMetasValidasServiceTest {

    FiltrarMetasValidasService tested;

    DesafioRequest request;
    List<DesafioMeta> metas;
    Long maxParticipantes = 100L;
    DesafioMeta metaValidaUm;
    DesafioMeta metaValidaDois;
    List<DesafioMeta> resultadoEsperado;

    @Before
    public void setup() {
        request = new DesafioRequest();

        metaValidaUm = new DesafioMeta();
        metaValidaUm.setQuantidadeColaboradores(50);
        metaValidaDois = new DesafioMeta();
        metaValidaDois.setQuantidadeColaboradores(75);
        metas = new ArrayList<>();
        metas.add(metaValidaUm);
        metas.add(metaValidaDois);

        resultadoEsperado = new ArrayList<>();
        resultadoEsperado.add(metaValidaUm);
        resultadoEsperado.add(metaValidaDois);

        tested = new FiltrarMetasValidasService();
    }

    @Test
    public void deveFiltrarListaDeMetasCorretamenteQuandoTiverMetaComQuantidadeMaiorQueMaximoDeParticipantes() {

        DesafioMeta metaInvalida = new DesafioMeta();
        metaInvalida.setQuantidadeColaboradores(110);

        metas.add(metaInvalida);
        request.setMetas(metas);

        List<DesafioMeta> result = tested.filtrar(request, maxParticipantes);

        Assert.assertNotNull(result);
        Assert.assertEquals(resultadoEsperado, result);
    }

    @Test
    public void deveFiltrarListaDeMetasCorretamenteQuandoTiverMetaComQuantidadeZero() {

        DesafioMeta metaInvalida = new DesafioMeta();
        metaInvalida.setQuantidadeColaboradores(0);

        metas.add(metaInvalida);
        request.setMetas(metas);

        List<DesafioMeta> result = tested.filtrar(request, maxParticipantes);

        Assert.assertNotNull(result);
        Assert.assertEquals(resultadoEsperado, result);
    }

    @Test
    public void deveFiltrarListaDeMetasCorretamenteQuandoTiverMetaComQuantidadeNula() {

        DesafioMeta metaInvalida = new DesafioMeta();
        metaInvalida.setQuantidadeColaboradores(null);

        metas.add(metaInvalida);
        request.setMetas(metas);

        List<DesafioMeta> result = tested.filtrar(request, maxParticipantes);

        Assert.assertNotNull(result);
        Assert.assertEquals(resultadoEsperado, result);
    }

    @Test
    public void naoDeveFiltrarListaComApenasMetasValidas() {

        request.setMetas(metas);

        List<DesafioMeta> result = tested.filtrar(request, maxParticipantes);

        Assert.assertNotNull(result);
        Assert.assertEquals(resultadoEsperado, result);
    }
}