package classes;

import enums.TipoPersonagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;
import personagens.Personagem;

public class Guerreiro extends Personagem {
    public Guerreiro(int forca, int agilidade, int inteligencia, int constituicao, String letra, TipoPersonagem tipo) {
        super(forca, agilidade, inteligencia, constituicao, letra, tipo);
    }

    @Override
    public void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        int dano = getForca() * 2;
        Personagem inimigo = mapa.buscarCasa(proximaPosicao(mapa));

        if (podeAtacar(inimigo))
            inimigo.setConstituicao(inimigo.getConstituicao() - dano);
    }

    @Override
    public void caminhar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        int proximaPosicao = proximaPosicao(mapa);

        if (mapa.buscarCasa(proximaPosicao) == null) {
            mapa.tirarDoMapa(this);
            mapa.inserir(proximaPosicao, this);
        }
    }
}
