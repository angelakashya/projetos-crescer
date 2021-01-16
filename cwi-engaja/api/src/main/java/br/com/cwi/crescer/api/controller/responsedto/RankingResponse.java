package br.com.cwi.crescer.api.controller.responsedto;

import lombok.Data;

import java.util.List;

@Data
public class RankingResponse {

    private List<UsuarioRankingResponse> global;
    private List<UsuarioRankingResponse> equipe;
}
