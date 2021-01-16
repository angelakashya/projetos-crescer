package br.com.cwi.crescer.melevaai.mapper;


import br.com.cwi.crescer.melevaai.controller.request.VeiculoRequest;
import br.com.cwi.crescer.melevaai.domain.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class VeiculoRequestMapper {


    public Veiculo convert(VeiculoRequest veiculoRequest){

        ModelMapper modelMapper = new ModelMapper();

        Veiculo veiculo = modelMapper.map(veiculoRequest, Veiculo.class);


        return veiculo;
    }


}

