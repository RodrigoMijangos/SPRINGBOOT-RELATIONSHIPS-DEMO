package com.example.springrelationshipsdemo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class IncidentesVinculacion {

    @EmbeddedId
    private IncidentesVinculacionKey id;

    @ManyToOne
    @MapsId("reporteId")
    @JoinColumn(name = "reporte")
    @JsonManagedReference
    private Incidente incidente;

    @ManyToOne
    @MapsId("carroId")
    @JoinColumn(name = "carro")
    @JsonManagedReference
    private Carro carro;

    private Double costos;

    public IncidentesVinculacion() {}

    public IncidentesVinculacion(IncidentesVinculacionKey id, Incidente incidente, Carro carro, Double costos) {
        this.id = id;
        this.incidente = incidente;
        this.carro = carro;
        this.costos = costos;
    }

    public IncidentesVinculacionKey getId() {
        return id;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Double getCostos() {
        return costos;
    }

    public void setCostos(Double costos) {
        this.costos = costos;
    }
}