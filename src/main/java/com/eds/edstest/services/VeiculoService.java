package com.eds.edstest.services;

import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public VeiculoDTO findById(Integer id){
        Veiculos result = veiculoRepository.findById(id).get();
        VeiculoDTO dto = new VeiculoDTO(result);
        return dto;
    }
    @Transactional
    public List<Veiculos> findAll(){
        List<Veiculos> result = veiculoRepository.findAll();
        return result;
    }

    public void delete(Integer id) {
        veiculoRepository.deleteById(id);
    }
    // public void save (Veiculos veiculos) {
    //   veiculoRepository.save(veiculos);
    //}
}