import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Leitor {

    private static final String CAMINHO = "./pessoas.json";

    public static List<Pessoa> buscarPessoas() {
        FileReader file;
        try {
            file = new FileReader(CAMINHO);
        } catch (FileNotFoundException e) {
            file = null;
        }

        return new Gson()
                .fromJson(new JsonReader(file), new TypeToken<List<Pessoa>>(){}
                .getType());
    }
}
