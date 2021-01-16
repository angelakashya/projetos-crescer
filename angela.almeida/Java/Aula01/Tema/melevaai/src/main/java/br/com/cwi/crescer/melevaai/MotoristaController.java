package br.com.cwi.crescer.melevaai;

import br.com.cwi.crescer.melevaai.domain.CPF;
import br.com.cwi.crescer.melevaai.domain.CarteiraNacionalDeHabilitacao;
import br.com.cwi.crescer.melevaai.domain.Categoria;
import br.com.cwi.crescer.melevaai.domain.Motorista;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


@RestController
public class MotoristaController {

    CPF cpf = new CPF("03326173008");
    CarteiraNacionalDeHabilitacao cnh = new CarteiraNacionalDeHabilitacao(28021997, Categoria.B, LocalDate.of(2023, 05, 15));
    Motorista motorista = new Motorista("Angela Patricia de Almeida", "angella.akashya@gmail.com", LocalDate.of(1997, 07, 03), cpf, cnh);

    @GetMapping("/motorista")
    public Motorista mostrarMotorista() {
        return motorista;
    }
}
