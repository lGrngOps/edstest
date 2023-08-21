package com.eds.edstest.services;

import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.dto.VeiculoFormAdd;
import com.eds.edstest.dto.VeiculoFormUpdate;
import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.repositories.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Transactional
    public VeiculoDTO addVeiculo(VeiculoFormAdd veiculoFormAdd){
        Veiculos veiculos = convertToAddVeiculo(veiculoFormAdd);
        veiculos = veiculoRepository.save(veiculos);
        return convertToVeiculoDTO(veiculos);
    }

    @Transactional
    public VeiculoDTO findVeiculoById(Long id){ // Retorna os detalhes do veiculo
        Optional<Veiculos> optional = veiculoRepository.findById(id);
        if (optional.isPresent()){
            return convertToVeiculoDTO(optional.get());
        }
        return null;
    }

    @Transactional
    public List<VeiculoDTO> findAllVeiculos(){ // Retorna todos os veiculos
        List<Veiculos> result = veiculoRepository.findAll();
        return convertListToDTO(result);
    }

    @Transactional
    public void deleteById(Long id) { // Apaga o veiculo
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
        }
    }

    @Transactional
    public VeiculoDTO updateById(VeiculoFormUpdate veiculoFormUpdate, Long id){ // Atualiza os dados de um veiculo
        Optional<Veiculos> optional = veiculoRepository.findById(id);

        if (optional.isPresent()){
            Veiculos upt = optional.get();

                upt.setMarca(veiculoFormUpdate.getMarca());
                upt.setVeiculo(veiculoFormUpdate.getVeiculo());
                upt.setAno(veiculoFormUpdate.getAno());
                upt.setDescricao(veiculoFormUpdate.getDescricao());
                upt.setPreco(veiculoFormUpdate.getPreco());
                upt.setChassi(veiculoFormUpdate.getChassi());
                upt.setVendido(veiculoFormUpdate.getVendido());
                upt.setUpdated(veiculoFormUpdate.getUpdated());

            veiculoRepository.save(upt);
            return convertToVeiculoDTO(upt);
        }
        return null;
    }

    private Veiculos convertToAddVeiculo (VeiculoFormAdd veiculoFormAdd){
        Veiculos veiculos = new Veiculos();
        veiculos.setMarca(veiculoFormAdd.getMarca());
        veiculos.setVeiculo(veiculoFormAdd.getVeiculo());
        veiculos.setAno(veiculoFormAdd.getAno());
        veiculos.setDescricao(veiculoFormAdd.getDescricao());
        veiculos.setPreco(veiculoFormAdd.getPreco());
        veiculos.setChassi(veiculoFormAdd.getChassi());
        veiculos.setVendido(veiculoFormAdd.getVendido());
        veiculos.setCreated(veiculoFormAdd.getCreated());
        veiculos.setUpdated(veiculoFormAdd.getUpdated());
        return veiculos;
    }

    private VeiculoDTO convertToVeiculoDTO (Veiculos veiculos){
        VeiculoDTO dto = new VeiculoDTO();
        dto.setId(veiculos.getId());
        dto.setMarca(veiculos.getMarca());
        dto.setVeiculo(veiculos.getVeiculo());
        dto.setAno(veiculos.getAno());
        dto.setDescricao(veiculos.getDescricao());
        dto.setPreco(veiculos.getPreco());
        dto.setChassi(veiculos.getChassi());
        dto.setVendido(veiculos.getVendido());
        dto.setCreated(veiculos.getCreated());
        dto.setUpdated(veiculos.getUpdated());
        return dto;
    }

    private static List<VeiculoDTO> convertListToDTO(List<Veiculos> veiculos){
        return veiculos.stream().map(VeiculoDTO::new).collect(Collectors.toList());
    }
}
