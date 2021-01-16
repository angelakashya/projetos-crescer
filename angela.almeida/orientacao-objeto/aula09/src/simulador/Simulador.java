package simulador;

import enums.TipoPersonagem;
import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import exceptions.SauronDominaOMundoException;
import mapa.Mapa;
import personagens.Personagem;

public class Simulador {
    Mapa mapa;

    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }

    private void rodarTurno() throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        for (int i = 0; i < mapa.getPersonagensNoMapa().size(); i++) {
            Personagem personagem = mapa.getPersonagensNoMapa().get(i);
            if(personagem != null) {
                personagem.atacar(mapa);
                try {
                    personagem.caminhar(mapa);
                } catch(PosicaoOcupadaException e) { }
            }
        }
        mapa.removerMortos();
    }

    public void simular() throws PosicaoOcupadaException, PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, SauronDominaOMundoException {
        boolean batalhaFinalizada = false;

        while(!batalhaFinalizada) {
            rodarTurno();
            batalhaFinalizada = verificarStatusBatalhaFinalizado();
        }
    }

    private boolean verificarStatusBatalhaFinalizado() throws SauronDominaOMundoException {
        Personagem personagem = mapa.buscarCasa(Mapa.TAMANHO - 1);
        if(personagem != null && personagem.getTipo() == TipoPersonagem.SOCIEDADE_DO_ANEL)
            return true;
        else if(!mapa.verificarSeExistePersonagemDoTipoNoMapa(TipoPersonagem.SOCIEDADE_DO_ANEL))
            throw new SauronDominaOMundoException();

        return false;
    }
}
