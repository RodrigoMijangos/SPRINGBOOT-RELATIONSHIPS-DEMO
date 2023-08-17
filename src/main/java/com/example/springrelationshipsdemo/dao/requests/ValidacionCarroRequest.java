package com.example.springrelationshipsdemo.dao.requests;

public class ValidacionCarroRequest {

    private Integer carro_id;
    private Double costos;

    public ValidacionCarroRequest(Integer carro_id, Double costos) {
        this.carro_id = carro_id;
        this.costos = costos;
    }

    public Integer getCarro_id() {
        return carro_id;
    }

    public void setCarro_id(Integer carro_id) {
        this.carro_id = carro_id;
    }

    public Double getCostos() {
        return costos;
    }

    public void setCostos(Double costos) {
        this.costos = costos;
    }
}