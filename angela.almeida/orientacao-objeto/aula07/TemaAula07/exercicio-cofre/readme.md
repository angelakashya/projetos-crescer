## Cofre

![Cofre](https://www.thedaviscompanies.com/wp-content/uploads/2018/05/Union-Trust-Bank-Vault-Cropped.jpg)

Vamos implementar um cofre que só abre para pessoas autorizadas.

### Pessoa

Esta classe é populada com as informações do arquivo `pessoas.json`. Os atributos de uma pessoa são:

- `Nome`
- `Perfil`
- `Senha`: Um hash do formato MD5 ([o que é](https://searchsecurity.techtarget.com/definition/MD5), [como usar no java](https://www.baeldung.com/java-md5), [criar hash online](http://www.md5.cz/)).
- `Localização`: Array de doubles com 2 posições (latitude e longitude), da cidade onde esta pessoa mora.
- `Biometria`: Array de doubles com 128 posições, gerado com um modelo de reconhecimento facial.

### Perfil

Cada perfil possui uma `String descricao` e uma `int permissao`, uma pessoa deve ter um dos 4 perfis abaixo:

- `CRESCER`: Descrição: "Crescer", permissão: 1.
- `INSTRUTOR`: Descrição: "Instrutor", permissão: 2.
- `MARKETING`: Descrição: "Marketing", permissão: 2.
- `GERENTE`: Descrição: "Gerente", permissão: 4.

### Cofre

Para ser criado um cofre precisa de um mapa de pessoas autorizadas a abri-lo, bem como uma diferença máxima e uma distância máxima. Nenhum destes atributos pode ser alterado após a 
criação do cofre.

O mapa de pessoas deve conseguir buscar pessoas utilizando seus respectivos logins.

A diferença máxima é usada para validar se a biometria da pessoa tentando abrir o cofre é parecida com a daquela pessoa no mapa de autorizados. Exemplo: a distância entre a minha
biometria facial e a do Fábio é 0.3817282726225318.

A distância máxima é usada para validar se a localização de uma pessoa tentando abrir o cofre é próxima da localização a daquela pessoa no mapa de autorizados. Exemplo: a distancia 
entre Novo Hamburgo e Canoas é 4.379673856526476.

Podemos utilizar distância euclidiana para calcular tanto a distância como a diferença:

d² = (pontoDoAutorizado[0] - pontoDoSolicitante[0])² + (pontoDoAutorizado[1] - pontoDoSolicitante[1])² + ... + (pontoDoAutorizado[n] - pontoDoSolicitante[n])²

Obs.: cuidem para não colocar um valor negativo na raiz (procurem como calcular o módulo de um número).

Esta classe possui um único método público, com a assinatura `boolean abrir(String login, Perfil perfil, String senha, double[] biometria, double[] geolocalizacao)`, ele valida 5 coisas:

- Se o login existe nos autorizados;
- Se o perfil é igual ao perfil do autorizado;
- Se a senha (após encriptada) é igual ao hash do autorizado;
- Se a biometria possui uma diferença menor que a diferença máxima permitida, em relação ao autorizado;
- Se a geolocalização está a uma distância menor que a distância máxima permitida, em relação ao autorizado.

Se todas as validações forem positivas, este método retorna `true`, caso qualquer uma delas não passe, o retorno deve ser `false`.

### Exceptions

O sistema deve lançar duas exceptions:

- `BiometriaComFormatoIncorretoException`: Lançada caso o tamanho do array de biometria informado ao Cofre seja diferente de 128.
- `GeolocalizacaoComFormatoIncorretoException` : Lançada caso o tamanho do array de localização informado ao Cofre seja diferente de 2.

**Dicas:**

**- Criem o Perfil e já rodem o PessoaTest, todos os testes devem passar sem nenhuma alteração;**

**- O Leitor retorna uma lista, mas o cofre precisa de um mapa;**

**- Todas as senhas estão no formato SenhaDo<Nome> ex.: SenhaDoVictor;**

### Exemplo de teste

```
public class CofreTest {
    private Map<String, Pessoa> autorizados;
    
    @Before
    public void criarHashMapComOsInstrutores() {
        this.autorizados = new HashMap<>();
    
        List<Pessoa> pessoas = Leitor.buscarPessoas();
    
        autorizados.put("victor.damke", pessoas.get(0));
        autorizados.put("fabioblumm", pessoas.get(1));
        autorizados.put("pablo.oliveira", pessoas.get(2));
        autorizados.put("diuly.barreto", pessoas.get(3));
    }
    
    @Test
    public void deveAbrirCofreQuandoPessoaEstiverNaListaDeAutorizados() throws NoSuchAlgorithmException, BiometriaComFormatoIncorretoException, GeolocalizacaoComFormatoIncorretoException {
        String login = "victor.damke";
        String senha = "SenhaDoVictor";
        Perfil perfil = Perfil.INSTRUTOR;
        double[] geolocalizacao = {-29.686930, -51.127550};
        double[] biometria = {-0.0717240795493126,0.200424239039421,0.0795498192310333,-0.0251115821301937,-0.0814622119069099,0.029400322586298,-0.0213277991861105,-0.121166698634624,0.137610971927643,-0.121532410383224,0.219820812344551,0.0326585657894611,-0.202189430594444,0.0765653625130653,0.00401705782860518,0.0909221544861794,-0.140626832842827,-0.0937680155038834,-0.15438623726368,-0.12654148042202,0.0755802318453789,0.0510320290923119,-0.0419369973242283,0.115638792514801,-0.185452610254288,-0.213810309767723,-0.0835670977830887,-0.0531335696578026,0.194502651691437,-0.0575171895325184,-0.0845270082354546,-0.0414815619587898,-0.185585513710976,-0.00712401419878006,-0.00706483703106642,-0.0405994169414043,-0.0177285149693489,-0.118289694190025,0.197652652859688,0.00473394803702831,-0.124115504324436,0.0695038661360741,0.0517630875110626,0.247236296534538,0.182528674602509,0.0120388949289918,0.0902915671467781,-0.0855348259210587,0.137425035238266,-0.24683965742588,0.070648729801178,0.135296046733856,0.128352895379066,0.13893735408783,0.0129938125610352,-0.260438621044159,0.0118288304656744,0.151524245738983,-0.209388762712479,0.184834316372871,0.0698952227830887,-0.123996213078499,-0.028987143188715,-0.0314105451107025,0.124371588230133,0.089169517159462,-0.102745182812214,-0.176323086023331,0.0989512652158737,-0.208186864852905,0.0151518899947405,0.102145493030548,-0.0984270945191383,-0.202222555875778,-0.251518040895462,0.113038398325443,0.406335115432739,0.292576491832733,-0.160103693604469,0.0283763613551855,-0.0628431364893913,-0.0207597371190786,0.0996167063713074,0.0557213723659515,-0.0873976349830627,-0.107157692313194,-0.0916686803102493,0.117477178573608,0.244352534413338,0.00656623207032681,0.0039253318682313,0.296879529953003,0.0599085837602615,-0.031019264832139,-0.0594459995627403,0.102026894688606,-0.189244881272316,-0.0255255550146103,-0.0100112166255713,0.0563904717564583,-0.0312739089131355,-0.0449331514537334,0.0229957215487957,0.0882981270551682,-0.218520402908325,0.209871992468834,-0.047384861856699,-0.0291850529611111,-0.0479375459253788,-0.0050220899283886,-0.115637965500355,-0.0140184136107564,0.149251565337181,-0.245322212576866,0.15214766561985,0.222329303622246,0.0643958821892738,0.158732324838638,0.0528756827116013,0.0589691326022148,0.0725817978382111,-0.0196244567632675,-0.140394330024719,-0.0864106267690659,0.0804716646671295,-0.130521312355995,0.0442943871021271,0.0199476405978203};
        Cofre cofre = new Cofre(this.autorizados, 0.1, 2);
    
        boolean resultado = cofre.abrir(login, perfil, senha, biometria, geolocalizacao);
    
        Assert.assertTrue(resultado);
    }
}
```

Obs.: Para incluir o pacote do gson (que lê o pessoas.json) vá em **File** -> **Project Structure** -> **Libraries** -> **+** -> **From Maven** -> Colar isto
na barra de pesquisa -> com.google.code.gson:gson:2.3 -> Clicar na lupa -> Esperar (demora uns segundos) -> Selecionar o primeiro da lista -> **OK** -> **OK** -> **OK**