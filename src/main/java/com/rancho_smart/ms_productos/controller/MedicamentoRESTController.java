package com.rancho_smart.ms_productos.controller;

import com.rancho_smart.ms_productos.entity.Medicamento;
import com.rancho_smart.ms_productos.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/medicamentos")
public class MedicamentoRESTController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public ResponseEntity<List<Medicamento>> getAllMedicamentos() {
        List<Medicamento> listado = medicamentoService.obtenerTodos();
        return new ResponseEntity<>(listado, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id) {
        Optional<Medicamento> medicamento = medicamentoService.obtenerPorId(id);
        return medicamento.map(ResponseEntity::ok)
                          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Medicamento> saveMedicamento(@RequestBody Medicamento medicamento) {
        Medicamento medicamentoCreado = medicamentoService.guardarMedicamento(medicamento);
        return new ResponseEntity<>(medicamentoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Long id, @RequestBody Medicamento medicamento) {
        if (!medicamentoService.obtenerPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            medicamento.setIdMedicamento(id);
            Medicamento medicamentoActualizado = medicamentoService.guardarMedicamento(medicamento);
            return new ResponseEntity<>(medicamentoActualizado, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        if (!medicamentoService.obtenerPorId(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            medicamentoService.eliminarMedicamento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
