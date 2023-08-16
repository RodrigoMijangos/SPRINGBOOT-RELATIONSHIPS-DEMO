package com.example.springrelationshipsdemo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reporte;
    private String lugar;
    private LocalDate fecha;

    public Incidente(){}

    public Incidente(Integer id, String lugar, LocalDate fecha){

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}