package br.com.cwi.crescer.api.service.desafio;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.DesafioMeta;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VerificarPrestacaoDeContasServiceTest {

    @InjectMocks
    VerificarPrestacaoDeContasService tested;

    @Test
    public void deveVerificarComSucesso() {

        Desafio desafio = new Desafio();
        DesafioMeta desafioMeta = new DesafioMeta();
        List<DesafioMeta> metas = new ArrayList<>();
        desafioMeta.setDesafio(desafio);
        desafioMeta.setRecompensa("Geladeira de cerveja");
        desafioMeta.setDescricaoPrestacao("Está no sexto andar a geladeira, aproveitem com moderação!");
        desafioMeta.setImagemPrestacao(null);
        metas.add(desafioMeta);
        desafio.setMetas(metas);

        tested.verificar(desafio);

        Assert.assertNotNull(desafio);

    }

}
