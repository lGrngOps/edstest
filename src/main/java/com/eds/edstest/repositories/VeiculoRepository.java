package com.eds.edstest.repositories;

import com.eds.edstest.entities.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculos, Long> {

    public List<Veiculos> findByOrderByVeiculoAsc();
    public List<Veiculos> findByVendidoTrue();

    @Query(value = "select m from Veiculos m where upper(trim(m.marca)) like %?1%")
    List<Veiculos> sistemaBuscar(String marca);

}
