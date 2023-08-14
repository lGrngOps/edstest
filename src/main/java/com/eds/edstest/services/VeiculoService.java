package com.eds.edstest.services;

import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculos> findAll(){
        List<Veiculos> result = veiculoRepository.findAll();
        return result;
    }
}
