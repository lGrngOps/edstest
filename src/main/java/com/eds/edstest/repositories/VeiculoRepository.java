package com.eds.edstest.repositories;

import com.eds.edstest.entities.Veiculos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculos, Long> {
}
