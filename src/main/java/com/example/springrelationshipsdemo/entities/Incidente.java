package com.example.springrelationshipsdemo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reporte;
    private String lugar;
    private LocalDateTime fecha;

    public Incidente(){}

    public Incidente(Integer id, String lugar, LocalDateTime fecha){

        this.reporte = id;
        this.lugar = lugar;
        this.fecha = fecha;

    }

    public Integer getId() {
        return reporte;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}