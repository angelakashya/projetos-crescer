package br.com.cwi.crescer.melevaai.controller;


import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import br.com.cwi.crescer.melevaai.mapper.VeiculoRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("veiculo")
public class VeiculoController {

    private VeiculoRequestMapper veiculoRequestMapper;

    @Autowired
    

    public VeiculoController() {
        this.veiculoRequestMapper = new VeiculoRequestMapper();
    }

    public Veiculo cadastrar(@RequestBody VeiculoRequest veiculoRequest){
        return veiculoRequestMapper.convert(veiculoRequest);
    }



}

