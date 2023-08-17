package com.example.springrelationshipsdemo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Table(name = "carros_incidentes")
public class IncidentesVinculacionKey implements Serializable {

    @Column(name = "reporte")
    private Integer reporteId;

    @Column(name = "carro")
    private Integer carroId;

    public IncidentesVinculacionKey() {}

    public IncidentesVinculacionKey(Integer reporteId, Integer carroId) {
        this.reporteId = reporteId;
        this.carroId = carroId;
    }

    public Integer getReporteId() {
        return reporteId;
    }

    public void setReporteId(Integer reporteId) {
        this.reporteId = reporteId;
    }

    public Integer getCarroId() {
        return carroId;
    }

    public void setCarroId(Integer carroId) {
        this.carroId = carroId;
    }

    @Override
    public int hashCode() {
        return this.carroId.hashCode() + this.reporteId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentesVinculacionKey that = (IncidentesVinculacionKey) o;
        return Objects.equals(reporteId, that.reporteId) && Objects.equals(carroId, that.carroId);
    }

}