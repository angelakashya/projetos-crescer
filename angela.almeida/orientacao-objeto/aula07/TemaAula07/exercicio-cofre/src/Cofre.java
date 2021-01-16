import java.util.*;

public class Cofre {

    private final Map<String, Pessoa> pessoa;

    private int diferencaMaxima;
    private int distanciaMaxima;

    public Cofre(Map<String, Pessoa> pessoa, int diferencaMaxima, int distanciaMaxima) {
        this.pessoa = pessoa;
        this.diferencaMaxima = diferencaMaxima;
        this.distanciaMaxima = distanciaMaxima;
    }


    private boolean isTrue(String login, Perfil perfil, String senha, double[] biometria, double[] geolocalizacao) {
        for(int i = 0; i < pessoa.size(); i++) {
            if(pessoa.get(i).getNome() == login)
                return true;
            else if(pessoa.get(i).getSenha() == senha)
                return true;
            else if(Arrays.asList(pessoa.get(i).getBiometria()).containsAll(Arrays.asList(biometria)))
                return true;
            else if (Arrays.asList(pessoa.get(i).getLocalizacao()).containsAll(Arrays.asList(geolocalizacao)))
                return true;
        }
        return false;
    }

    public boolean abrir(String login, Perfil perfil, String senha, double[] biometria, double[] geolocalizacao) {
        if(isTrue(login, perfil, senha, biometria, geolocalizacao))
            return true;
        else
            return false;
    }
}
