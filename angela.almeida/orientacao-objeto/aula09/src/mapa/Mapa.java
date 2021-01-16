package mapa;

import enums.TipoPersonagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.List;

public class Mapa {


    public static final int TAMANHO = 10;
    private Personagem[] mapa = new Personagem[TAMANHO];
    private List<Personagem> personagensNoMapa = new ArrayList<>();

    public String exibir() {
        StringBuilder resultado = new StringBuilder("|");
        for (int i = 0; i < this.mapa.length; i++) {
            if (this.mapa[i] == null)
                resultado.append(" |");
            else
                resultado.append(this.mapa[i].toString()).append("|");
        }
        return resultado.toString();
    }


    public void inserir(int posicao, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (mapa[posicao] != null)
            throw new PosicaoOcupadaException();

        try {
            int buscarPosicao = buscarPosicao(personagem);
            throw new PersonagemJaEstaNoMapaException();
        } catch (PersonagemNaoEncontradoNoMapaException e) {
            mapa[posicao] = personagem;

            if (!personagensNoMapa.contains(personagem)) {
                personagensNoMapa.add(personagem);
            }
        }

    }

    public int buscarPosicao(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException {
        for (int i = 0; i < mapa.length; i++) {
            if (mapa[i] == personagem)
                return i;
        }

        throw new PersonagemNaoEncontradoNoMapaException();
    }

    public Personagem buscarCasa(int posicao) {
        if (mapa[posicao] != null)
            return mapa[posicao];
        else
            return null;
    }

    public void tirarDoMapa(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException {
        int posicao = buscarPosicao(personagem);
        mapa[posicao] = null;
    }

    public boolean estaVazio(Personagem personagem) {
        for (int i = 0; i < TAMANHO; i++) {
            if (mapa[i] != null && mapa[i].toString() != personagem.toString())
                return false;
        }
        return true;
    }

    public boolean verificarSeExistePersonagemDoTipoNoMapa(TipoPersonagem tipoPersonagem) {
        for (int i = 0; i < TAMANHO; i++) {
            if (mapa[i] != null && mapa[i].getTipo() == tipoPersonagem)
                return true;
        }
        return false;
    }

    public void removerMortos() throws PersonagemNaoEncontradoNoMapaException {
        for (int i = 0; i < TAMANHO; i++) {
            Personagem personagem = mapa[i];
            if (personagem != null && personagem.getConstituicao() <= 0) {
                tirarDoMapa(personagem);
                personagensNoMapa.remove(personagem);
            }
        }
    }

    public List<Personagem> getPersonagensNoMapa() {
        return personagensNoMapa;
    }
}
