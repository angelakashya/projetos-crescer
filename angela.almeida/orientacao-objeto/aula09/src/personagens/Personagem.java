package personagens;

import enums.TipoPersonagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import mapa.Mapa;

public abstract class Personagem {
    private final int forca;
    private final int agilidade;
    private final int inteligencia;
    private int constituicao;
    private final String letra;
    private final TipoPersonagem tipo;

    public Personagem(int forca, int agilidade, int inteligencia, int constituicao, String letra, TipoPersonagem tipo) {
        this.forca = forca;
        this.agilidade = agilidade;
        this.inteligencia = inteligencia;
        this.constituicao = constituicao;
        this.letra = letra;
        this.tipo = tipo;
    }

    protected boolean podeAtacar(Personagem inimigo) {
        return inimigo != null && tipo != inimigo.getTipo();
    }

    public TipoPersonagem getTipo() {
        return tipo;
    }

    public int distancia(Personagem personagem, Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        int posicaoPersonagemAtual = mapa.buscarPosicao(personagem);
        int posicaoPersonagemAlvo = mapa.buscarPosicao(this);

        if (posicaoPersonagemAtual > posicaoPersonagemAlvo) {
            return posicaoPersonagemAtual - posicaoPersonagemAlvo;
        } else
            return posicaoPersonagemAlvo - posicaoPersonagemAtual;
    }

    protected int proximaPosicao(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException {
        int posicaoDoPersonagem = mapa.buscarPosicao(this);
        if (getTipo() == TipoPersonagem.SOCIEDADE_DO_ANEL && mapa.TAMANHO > posicaoDoPersonagem + 1) {
            return posicaoDoPersonagem + 1;
        } else if (getTipo() == TipoPersonagem.LEGIAO_DE_SAURON && posicaoDoPersonagem - 1 > 0) {
            return posicaoDoPersonagem - 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return letra;
    }

    public abstract void atacar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException;

    public abstract void caminhar(Mapa mapa) throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException;

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public String getLetra() {
        return letra;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }
}
