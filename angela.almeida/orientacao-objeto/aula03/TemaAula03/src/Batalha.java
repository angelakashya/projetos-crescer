public class Batalha {
    public Ninja lutar(Ninja primeiroNinja, Ninja segundoNinja) {
        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);
        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);
        primeiroNinja.atacar(segundoNinja);
        segundoNinja.atacar(primeiroNinja);

        if (primeiroNinja.getNome().equalsIgnoreCase("Itachi")) {
            return primeiroNinja;
        } else if (segundoNinja.getNome().equalsIgnoreCase("Itachi")) {
            return segundoNinja;
        } else if (primeiroNinja.getChakra() > segundoNinja.getChakra()) {
            return primeiroNinja;
        } else if (segundoNinja.getChakra() > primeiroNinja.getChakra()) {
            return segundoNinja;
        } else
            return primeiroNinja;
    }
}
