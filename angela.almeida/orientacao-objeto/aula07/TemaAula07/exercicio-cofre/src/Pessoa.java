
public class Pessoa {

    private String nome;

    private String senha;

    private double[] biometria;

    private double[] localizacao;

    private Perfil perfil;

    public Pessoa() {}

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public double[] getBiometria() {
        return biometria;
    }

    public double[] getLocalizacao() {
        return localizacao;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setBiometria(double[] biometria) {
        this.biometria = biometria;
    }

    public void setLocalizacao(double[] localizacao) {
        this.localizacao = localizacao;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
