package com.example.springrelationshipsdemo.dao.requests;

public class PersonaRequest {

    private String nombre;
    private String direccion;

    public PersonaRequest() {    }

    public PersonaRequest(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}