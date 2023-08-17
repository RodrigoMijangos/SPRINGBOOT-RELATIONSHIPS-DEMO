package com.example.springrelationshipsdemo.services;

import com.example.springrelationshipsdemo.entities.Carro;
import com.example.springrelationshipsdemo.entities.Incidente;
import com.example.springrelationshipsdemo.entities.IncidentesVinculacion;
import com.example.springrelationshipsdemo.repositories.IncidentesVinculacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class VinculacionServicio {

    @Autowired
    private IncidentesVinculacionRepositorio repositorio;

    @Autowired
    private CarroServicio carroServicio;

    @Autowired
    private IncidenteServicio incidenteServicio;

    public IncidentesVinculacion vincularCarro(Integer reporte, Integer carro_id, Double costos){

        Incidente incidente = incidenteServicio.find(reporte);

        if (incidente == null)
            return null;

        Carro carro = carroServicio.find(carro_id);

        if(carro == null)
            return null;

        IncidentesVinculacion vinculacion = new IncidentesVinculacion();

        vinculacion.setIncidente(incidente);
        vinculacion.setCarro(carro);
        vinculacion.setCostos(costos);

        return repositorio.save(vinculacion);

    }

}