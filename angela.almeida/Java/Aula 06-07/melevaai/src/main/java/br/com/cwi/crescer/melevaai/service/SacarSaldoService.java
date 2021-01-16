package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Motorista;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.MotoristaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class SacarSaldoService {

    private MotoristaRepository motoristaRepository;

    public void sacarSaldo(@PathVariable("cpfmotorista") String cpfmotorista, @RequestParam double saldo){
        Motorista motorista= motoristaRepository.findAll()
                .stream()
                .filter(m -> m.getCpf().getNumero().equals(cpfmotorista))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Erro"));

        if (motorista.getContaVirtual().getSaldo() < saldo)
            throw new ValidacaoNegocioException("Saldo Insuficiente");

        motorista.getContaVirtual().setSaldo(motorista.getContaVirtual().getSaldo() - saldo);
    }
}
