package com.rancho_smart.ms_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_productos.entity.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
    
}
