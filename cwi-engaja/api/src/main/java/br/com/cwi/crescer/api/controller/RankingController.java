package br.com.cwi.crescer.api.controller;

import br.com.cwi.crescer.api.controller.responsedto.RankingResponse;
import br.com.cwi.crescer.api.service.ranking.GerarRankingResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/ranking")
public class RankingController {

    @Autowired
    GerarRankingResponseService rankingService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public RankingResponse ranking() {
        return rankingService.gerar();
    }

}
