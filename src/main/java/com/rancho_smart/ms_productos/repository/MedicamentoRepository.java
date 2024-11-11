package com.rancho_smart.ms_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rancho_smart.ms_productos.entity.Medicamento;
import java.util.List;


public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{
    public List<Medicamento> findByIdFinca(Long idFinca);
    public List<Medicamento> findByIdUsuario(Long idUsuario);
}
