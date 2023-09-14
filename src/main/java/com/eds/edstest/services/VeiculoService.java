package com.eds.edstest.services;

import com.eds.edstest.dto.VeiculoDTO;
import com.eds.edstest.dto.VeiculoFormAdd;
import com.eds.edstest.dto.VeiculoFormUpdate;
import com.eds.edstest.entities.Veiculos;
import com.eds.edstest.repositories.VeiculoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository veiculoRepository;

    @Transactional
    public VeiculoDTO addVeiculo(VeiculoFormAdd veiculoFormAdd){
        Veiculos veiculos = convertToAddVeiculo(veiculoFormAdd);
        veiculos = veiculoRepository.save(veiculos);
        return convertToVeiculoDTO(veiculos);
    }

    @Transactional
    public List<VeiculoDTO> findAllVeiculos(){ // Retorna todos os veiculos
        List<Veiculos> result = veiculoRepository.findAll();
        return convertListToDTO(result);
    }

    @Transactional // TESTADO E APROVADO
    public VeiculoDTO findVeiculoById(Long id){ // Retorna os detalhes do veiculo
        Optional<Veiculos> optional = veiculoRepository.findById(id);
        if (!optional.isPresent()){
            throw new IllegalArgumentException("Id :" + id + " não localizado");
        }
        else
            return convertToVeiculoDTO(optional.get());
    }

    @Transactional
    public List<VeiculoDTO> searchVeiculo(String marca){
        List<Veiculos> result = veiculoRepository.sistemaBuscar(marca);
        return convertListToDTO(result);
    }

    //@Transactional
    //public Page<Veiculos> getVeiculos(){
    //    Pageable pageable = PageRequest.of(0,5);
    //    return this.veiculoRepository.findAll(pageable);
    //}

    @Transactional
    public Page<Veiculos> getVeiculos(Pageable pageable){
        pageable = PageRequest.of(0,5);
        return this.veiculoRepository.findAll(pageable);
    }


    //@Transactional
    //public Page<Veiculos> findAllVeiculos(Pageable pageable){
    //    return veiculoRepository.findAll(pageable);
    //}

    //@Transactional
    //public String findAllVeiculos(Pageable pageable) {
    //    Page<Veiculos> page = veiculoRepository.findAll(PageRequest.of(0,5));
        //Page<Veiculos> page = veiculoService.listAll(PageRequest.of(0,5));
    //    return page.getContent().toString();
    //}

    @Transactional
    public Veiculos findByChassi(String chassi){
        Veiculos result = veiculoRepository.findByChassi(chassi);
        return result;
    }

    @Transactional
    // Teste Retorna os veículos de acordo com filtros passados através de query string
    public List<VeiculoDTO> findByOrderByVeiculoAsc(){
        List<Veiculos> result = veiculoRepository.findByOrderByVeiculoAsc();
        return convertListToDTO(result);
    }

    @Transactional
    // Teste Retorna os veículos de acordo com filtros passados através de query string
    public List<VeiculoDTO> findByVendidoTrue(){
        List<Veiculos> result = veiculoRepository.findByVendidoTrue();
        return convertListToDTO(result);
    }

    @Transactional // TESTADO E APROVADO
    public void deleteById(Long id) { // Apaga o veiculo
        if (veiculoRepository.existsById(id)) {
            veiculoRepository.deleteById(id);
        }
        else
            throw new IllegalArgumentException("Veículo não localizado");
    }

    @Transactional // TESTADO E APROVADO
    public VeiculoDTO updateById(VeiculoFormUpdate veiculoFormUpdate, Long id) { // Atualiza os dados de um veiculo
        Optional<Veiculos> optional = veiculoRepository.findById(id);

        if (!optional.isPresent()){
            throw new IllegalArgumentException("Falha ao atualizar informações do Veículo");
        }
        else {

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
