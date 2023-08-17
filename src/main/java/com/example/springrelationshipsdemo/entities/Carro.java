package com.example.springrelationshipsdemo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricula;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "duenio", nullable = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Persona duenio;

    public Carro(){}

    public Carro(Integer id, String matricula, String modelo, Persona duenio) {
        this.id = id;
        this.matricula = matricula;
        this.modelo = modelo;
        this.duenio = duenio;
    }

    public Integer getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Persona getDuenio() {
        return duenio;
    }

    public void setDuenio(Persona duenio) {
        this.duenio = duenio;
    }
}