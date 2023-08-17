package com.eds.edstest.controllers;
import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.dto.VeiculoFormAdd;
import com.eds.edstest.dto.VeiculoFormUpdate;
import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.services.VeiculoService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public VeiculoDTO addVeiculo (@RequestBody @Valid VeiculoFormAdd veiculoFormAdd){
        return veiculoService.addVeiculo(veiculoFormAdd);
    }

    @GetMapping("/{id}")
    public VeiculoDTO findVeiculoById(@PathVariable("id") Long id) {
        return veiculoService.findVeiculoById(id);
    }

    @GetMapping
    public List<VeiculoDTO> findAll() {
        return veiculoService.findAllVeiculos();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        veiculoService.deleteById(id);
    }

    @PutMapping("/{id}")
        public VeiculoDTO updateById(@RequestBody VeiculoFormUpdate formUpdate, @PathVariable("id") Long id){
        return veiculoService.updateById(formUpdate, id);
    }
}
