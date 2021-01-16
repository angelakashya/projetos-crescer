import org.junit.Test;

public class ExemplosTiposPrimitivos {
    @Test
    public void declaracaoVariaveisPrimitivas() {
        System.out.println("Hello World");

        System.out.println("Minha idade é 18");

        System.out.println("A soma de 1 +1: 2");

        //tipoDaVariavel nomeDaVariavel
        //minhaIdade deve valer (recebe) 18
        int minhaIdade = 23;
        int minhaIdadeAnoQueVem = 18 + 1;

        System.out.println("Minha idade é: " + minhaIdade);
        System.out.println("Minha idade ano que vem é: " + minhaIdadeAnoQueVem);
    }

    @Test
    public void outrosTiposPrimitivos() {
        double pi = 3.14159;
        System.out.println(pi);

        boolean ehColorado= true;
        System.out.println("Pablo eh colocado: " + ehColorado);

        char primeiraLetraMeuNome = 'a';
        System.out.println(primeiraLetraMeuNome);
    }

    @Test
    public void copia() {
        int primeiroValor = 1;
        int segundoValor = primeiroValor;
        System.out.println(segundoValor);

        primeiroValor = 2;
        System.out.println(segundoValor);
        System.out.println(primeiroValor);

        int minhaIdade = 18;
        int minhaIdadeAnoQueVem = 18 + 1;
        System.out.println(minhaIdadeAnoQueVem);
    }

    @Test
    public void cast() {
        int saldoNaCarteira = 10;
        System.out.println("Valor na carteira: " + saldoNaCarteira);

        double saldoNaCarteiraQuebrado = saldoNaCarteira;
        System.out.println("Valor na carteira double: " + saldoNaCarteiraQuebrado);

        saldoNaCarteiraQuebrado = 10.58;
        saldoNaCarteira= (int) saldoNaCarteiraQuebrado;
        System.out.println("Valor na carteira de cast: " + saldoNaCarteira);

        int a = 3;
        int b = 2;
        int divisao = a/b;
        System.out.println("Valor da divisão: " + divisao);
    }

    @Test
    public void texto() {
        String meuNome = "Angela Almeida";
        System.out.println("Meu nome é: " + meuNome);

        int minhaIdade = 23;
        int minhaIdadeAnoQueVem = minhaIdade + 1;

        //imprimir: minha idade é 23 e ano que vem sera 24
        System.out.println("Minha idade é: " + minhaIdade + "Minha idade ano que vem será: " + minhaIdadeAnoQueVem);
        System.out.printf("Minha idade é %d minha idade ano que vem será  %d", minhaIdade, minhaIdadeAnoQueVem);

        String descricaoIdade = "Minha idade é: " + minhaIdade + "Minha idade ano que vem será: " + minhaIdadeAnoQueVem;
        System.out.println(descricaoIdade);
    }

    @Test
    public void constante() {
        double VALOR_DE_PI = 3.14;
        double raio = 2;
        double area = VALOR_DE_PI * raio * raio;

        System.out.println(area);
        final String NOME = "Ângela";
    }
}
