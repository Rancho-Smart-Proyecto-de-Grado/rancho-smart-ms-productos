package com.rancho_smart.ms_productos.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MEDICAMENTO")
public class Medicamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;

    @Column(name = "NOMBRE")
    private String nombre; 

    @Column(name = "CANTIDAD")
    private Long cantidad;

    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "FABRICANTE")
    private String fabricante;

    @Column(name = "FECHA_FABRICACION")
    private LocalDate fechaFabricacion;

    @Column(name = "FECHA_EXPIRACION")
    private LocalDate fechaExpiracion;

    @Column(name = "VIA_ADMINISTRACION")
    private String viaAdministracion;
    
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    
    @Column(name = "ID_FINCA")
    private Long idFinca;

    public Medicamento() {
    }

    public Medicamento(String nombre, Long cantidad, String descripcion, String fabricante, LocalDate fechaFabricacion,
            LocalDate fechaExpiracion, String viaAdministracion, Long idUsuario, Long idFinca) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaExpiracion = fechaExpiracion;
        this.viaAdministracion = viaAdministracion;
        this.idUsuario = idUsuario;
        this.idFinca = idFinca;
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDate fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdFinca() {
        return idFinca;
    }

    public void setIdFinca(Long idFinca) {
        this.idFinca = idFinca;
    }

    


}
