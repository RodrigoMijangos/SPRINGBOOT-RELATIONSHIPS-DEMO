package com.example.springrelationshipsdemo.dao.requests;

public class CarroRequest {
    private String modelo;
    private String matricula;
    private Integer duenio_id;

    public CarroRequest(){}

    public CarroRequest(String modelo, String matricula, Integer duenio_id){

        this.modelo = modelo;
        this.matricula = matricula;
        this.duenio_id = duenio_id;

    }

    public String getModelo() {
        return modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public Integer getDuenio_id() {
        return duenio_id;
    }

}