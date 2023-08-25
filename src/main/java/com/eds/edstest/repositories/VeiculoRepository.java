package com.eds.edstest.repositories;

import com.eds.edstest.entities.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculos, Long> {

    public List<Veiculos> findByOrderByMarcaAsc();

    public List<Veiculos> findByVendidoTrue();

}
