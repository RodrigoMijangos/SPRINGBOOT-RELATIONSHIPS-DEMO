package com.example.springrelationshipsdemo.dao.requests;

public class ValidacionIncidenteRequest {

    private Integer incidente_id;

    private Double costos;

    public ValidacionIncidenteRequest(Integer incidente_id, Double costos) {
        this.incidente_id = incidente_id;
        this.costos = costos;
    }

    public Integer getIncidente_id() {
        return incidente_id;
    }

    public void setIncidente_id(Integer incidente_id) {
        this.incidente_id = incidente_id;
    }

    public Double getCostos() {
        return costos;
    }

    public void setCostos(Double costos) {
        this.costos = costos;
    }
}