package com.eds.edstest.controllers;

import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping(value = "/{id}")
    public VeiculoDTO findById(@PathVariable Integer id){
        VeiculoDTO result = veiculoService.findById(id);
        return result;
    }

    @GetMapping
    public List<Veiculos> findAll(){
        List<Veiculos> result = veiculoService.findAll();
        return result;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        veiculoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //@PostMapping
    //@ResponseBody
    //public ResponseEntity<Veiculos> save (@RequestBody Veiculos veiculos){
    //    return new ResponseEntity<>(veiculoService.save(veiculos), HttpStatus.CREATED);
    //}
}
