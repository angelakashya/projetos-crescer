package br.com.cwi.crescer.melevaai;

import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalDeHabilitacao;
import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    private static List<Motorista> motoristas = new ArrayList<>();

    CPF cpf = new CPF("03326173008");
    CarteiraNacionalDeHabilitacao cnh = new CarteiraNacionalDeHabilitacao(28021997, Categoria.B, LocalDate.of(2023, 05, 15));
    Motorista motorista = new Motorista("Angela Patricia de Almeida", "angella.akashya@gmail.com", LocalDate.of(1997, 07, 03), cpf, cnh);

    @GetMapping()
    public List<Motorista> mostrarMotoristas() {
        return motoristas;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Motorista criaMotorista(@RequestBody Motorista motorista) {
        for (Motorista motoristaList : motoristas) {
            if (motoristaList.getCpf().getNumero().equals(motorista.getCpf().getNumero()))
                throw new IllegalArgumentException();
        }
        if (motorista.getCpf() == null)
            throw new IllegalArgumentException();
        motoristas.add(motorista);
        return motorista;
    }

    @GetMapping("/{cpf}")
    public Motorista buscarPorCpf(@PathVariable String cpf) {
        for (Motorista motorista : motoristas) {
            if (motorista.getCpf().getNumero().equals(cpf)) {
                return motorista;
            }
        }
        throw new IllegalArgumentException();
    }

    @DeleteMapping("/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public void deletarMotorista(@PathVariable String cpf) {
        final Motorista motorista = buscarMotorista(cpf);
        motoristas.remove(motorista);
    }

    private Motorista buscarMotorista(String cpf) {
        for (Motorista motorista : motoristas) {
            if (motorista.getCpf().getNumero().equals(cpf)) {
                return motorista;
            }
        }
        throw new NotFoundException();
    }

}


