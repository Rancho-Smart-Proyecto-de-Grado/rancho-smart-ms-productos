package com.rancho_smart.ms_productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rancho_smart.ms_productos.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
