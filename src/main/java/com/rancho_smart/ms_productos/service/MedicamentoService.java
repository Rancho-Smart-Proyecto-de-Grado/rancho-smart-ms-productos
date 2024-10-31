package com.rancho_smart.ms_productos.service;

import com.rancho_smart.ms_productos.entity.Medicamento;
import com.rancho_smart.ms_productos.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<Medicamento> obtenerTodos() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento> obtenerPorId(Long idMedicamento) {
        return medicamentoRepository.findById(idMedicamento);
    }

    public Medicamento guardarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Medicamento actualizarMedicamento(Long idMedicamento, Medicamento medicamentoActualizado) {
        return medicamentoRepository.findById(idMedicamento)
            .map(medicamento -> {
                medicamento.setNombre(medicamentoActualizado.getNombre());
                medicamento.setCantidad(medicamentoActualizado.getCantidad());
                medicamento.setDescripcion(medicamentoActualizado.getDescripcion());
                medicamento.setFabricante(medicamentoActualizado.getFabricante());
                medicamento.setFechaFabricacion(medicamentoActualizado.getFechaFabricacion());
                medicamento.setFechaExpiracion(medicamentoActualizado.getFechaExpiracion());
                medicamento.setViaAdministracion(medicamentoActualizado.getViaAdministracion());
                medicamento.setIdUsuario(medicamentoActualizado.getIdUsuario());
                medicamento.setIdFinca(medicamentoActualizado.getIdFinca());
                return medicamentoRepository.save(medicamento);
            }).orElseThrow(() -> new RuntimeException("Medicamento no encontrado con id " + idMedicamento));
    }

    public void eliminarMedicamento(Long idMedicamento) {
        medicamentoRepository.deleteById(idMedicamento);
    }
}
