package br.com.cwi.crescer.api.scheduler;

import br.com.cwi.crescer.api.domain.Desafio;
import br.com.cwi.crescer.api.domain.Status;
import br.com.cwi.crescer.api.repository.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class EncerrarDesafiosMeiaNoite {

    @Autowired
    DesafioRepository repository;

    @Scheduled(cron = "0 0 0 * * *")
    public void encerrar() {
        List<Desafio> desafiosAEncerrar = repository
                .findByStatusAndDataLimiteBefore(Status.ATIVO, LocalDate.now());

        desafiosAEncerrar
                .forEach(d -> d.setStatus(Status.ENCERRADO));

        repository.saveAll(desafiosAEncerrar);
    }
}
