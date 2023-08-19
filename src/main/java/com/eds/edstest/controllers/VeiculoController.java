package com.eds.edstest.controllers;
import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.dto.VeiculoFormAdd;
import com.eds.edstest.dto.VeiculoFormUpdate;
import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.services.VeiculoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public VeiculoDTO addVeiculo (@Valid @RequestBody VeiculoFormAdd veiculoFormAdd){
        return veiculoService.addVeiculo(veiculoFormAdd);
    }

    @GetMapping("/{id}")
    public VeiculoDTO findVeiculoById(@PathVariable Long id) {
        return veiculoService.findVeiculoById(id);
    }

    @GetMapping
    public List<VeiculoDTO> findAll() {
        return veiculoService.findAllVeiculos();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        veiculoService.deleteById(id);
    }

    @PutMapping("/{id}")
        public VeiculoDTO updateById(@Valid @RequestBody VeiculoFormUpdate veiculoFormUpdate, @PathVariable Long id){
        return veiculoService.updateById(veiculoFormUpdate,id);
    }
}
