package com.example.springrelationshipsdemo.dao.requests;

import java.time.LocalDate;

public class IncidenteRequest {

    private String lugar;
    private LocalDate fecha;

    public IncidenteRequest(String lugar, LocalDate fecha) {
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public IncidenteRequest() {
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