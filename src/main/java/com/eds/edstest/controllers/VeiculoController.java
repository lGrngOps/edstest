package com.eds.edstest.controllers;

import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculos> findAll(){
        List<Veiculos> result = veiculoService.findAll();
        return result;
    }
}
