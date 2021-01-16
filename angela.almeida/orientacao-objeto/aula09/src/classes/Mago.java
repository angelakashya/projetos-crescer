package classes;

import enums.TipoPersonagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;
import personagens.Personagem;

public class Mago extends Personagem {

    public Mago(int forca, int agilidade, int inteligencia, int constituicao, String letra, TipoPersonagem tipo) {
        super(forca, agilidade, inteligencia, constituicao, letra, tipo);
    }

    private void atacar(Personagem inimigo){
        if(podeAtacar(inimigo))
            inimigo.setConstituicao(inimigo.getConstituicao() - getInteligencia());
    }

    @Override
    public void atacar(Mapa mapa) {
        for(int i = 0; i < mapa.TAMANHO; i++) {
            Personagem personagem = mapa.buscarCasa(i);
            atacar(personagem);
        }
    }
    @Override
    public void caminhar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        int proximaPosicao = proximaPosicao(mapa);

        if (mapa.estaVazio(this)) {
            mapa.tirarDoMapa(this);
            mapa.inserir(proximaPosicao, this);
        }
    }
}
