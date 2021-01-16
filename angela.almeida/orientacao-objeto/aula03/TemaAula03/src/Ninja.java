public class Ninja {
    private String nome;
    private int chakra;
    private Jutsu jutsuPrincipal;

    public Ninja(String nome, Jutsu jutsuPrincipal) {
        this.nome = nome;
        this.jutsuPrincipal = jutsuPrincipal;
        this.chakra = 100;
    }

    public int receberGolpe(int valorDoDanoRecebido) {
       this.chakra -= valorDoDanoRecebido;
        return this.chakra;
    }

    public void atacar(Ninja ninjaOponente) {
       ninjaOponente.receberGolpe(jutsuPrincipal.getDano());
    }

    public double getChakra() {
        return this.chakra;
    }

    public String getNome(){
        return this.nome;
    }
}
