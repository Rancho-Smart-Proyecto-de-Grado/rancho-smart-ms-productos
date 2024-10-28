package com.rancho_smart.ms_productos.service;

import com.rancho_smart.ms_productos.entity.Producto;
import com.rancho_smart.ms_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Long idProducto) {
        return productoRepository.findById(idProducto);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long idProducto, Producto productoActualizado) {
        return productoRepository.findById(idProducto)
            .map(producto -> {
                producto.setIdFinca(productoActualizado.getIdFinca());
                producto.setIdUsuario(productoActualizado.getIdUsuario());
                producto.setNombre(productoActualizado.getNombre());
                producto.setDescripcion(productoActualizado.getDescripcion());
                producto.setPrecio(productoActualizado.getPrecio());
                producto.setCantidad(productoActualizado.getCantidad());
                producto.setFechaRegistro(productoActualizado.getFechaRegistro());
                return productoRepository.save(producto);
            }).orElseThrow(() -> new RuntimeException("Producto no encontrado con id " + idProducto));
    }

    public void eliminarProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }
}
