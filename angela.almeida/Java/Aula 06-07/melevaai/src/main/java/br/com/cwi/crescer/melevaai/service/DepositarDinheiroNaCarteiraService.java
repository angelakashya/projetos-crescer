package br.com.cwi.crescer.melevaai.service;

import br.com.cwi.crescer.melevaai.domain.Passageiro;
import br.com.cwi.crescer.melevaai.exception.ValidacaoNegocioException;
import br.com.cwi.crescer.melevaai.repository.PassageiroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Optional;

@Service
public class DepositarDinheiroNaCarteiraService {

    PassageiroRepository passageiroRepository;

    public void depositarSaldo(@PathVariable("cpfpassageiro") String cpf, @RequestParam double saldo){
        if (saldo<=0)
            throw new ValidacaoNegocioException("Erro");

        Passageiro passageiro = passageiroRepository.findAll()
                .stream()
                .filter(m -> m.getCpf().getNumero().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new ValidacaoNegocioException("Erro"));


        passageiro.getContaVirtual().setSaldo(passageiro.getContaVirtual().getSaldo()+saldo);
    }


}
