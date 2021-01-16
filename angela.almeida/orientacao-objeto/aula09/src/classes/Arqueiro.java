package classes;

import enums.TipoPersonagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;
import personagens.Personagem;

import java.util.*;

public class Arqueiro extends Personagem {
    public Arqueiro(int forca, int agilidade, int inteligencia, int constituicao, String letra, TipoPersonagem tipo) {
        super(forca, agilidade, inteligencia, constituicao, letra, tipo);
    }

    private void atacar(Personagem inimigo, int distancia) {
        int dano = distancia * getAgilidade();

        if (podeAtacar(inimigo))
            inimigo.setConstituicao(inimigo.getConstituicao() - dano);
    }

    @Override
    public void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        Map<Integer, Personagem> map = new TreeMap<>();
        for (int i = 0; i < mapa.TAMANHO; i++) {
            Personagem personagem = mapa.buscarCasa(i);
            if (podeAtacar(mapa.buscarCasa(i)))
                map.put(distancia(personagem, mapa), personagem);
        }

        Map<Integer, Personagem> ordenado = map;
        ordenado = new TreeMap<Integer, Personagem>(Collections.reverseOrder());
        ordenado.putAll((map));

        for (Integer distancia : ordenado.keySet()) {
            if (distancia <= 3 && distancia >= 1) {
                this.atacar(map.get(distancia), distancia);
                return;
            }
        }
    }

    @Override
    public void caminhar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        int proximaPosicao = proximaPosicao(mapa);
        Personagem teste = mapa.buscarCasa(7);
        Personagem teste2 = mapa.buscarCasa(proximaPosicao);


        if (proximaPosicao + 1 < mapa.TAMANHO && mapa.buscarCasa(proximaPosicao + 1) == null && mapa.buscarCasa(proximaPosicao) == null) {
            mapa.tirarDoMapa(this);
            mapa.inserir(proximaPosicao + 1, this);
        } else if (proximaPosicao - 1 > 0 && mapa.buscarCasa(proximaPosicao) == null) {
            mapa.tirarDoMapa(this);
            mapa.inserir(proximaPosicao, this);
        }
    }
}
