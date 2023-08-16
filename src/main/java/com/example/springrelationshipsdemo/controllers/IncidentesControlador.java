package com.example.springrelationshipsdemo.controllers;

import com.example.springrelationshipsdemo.entities.Incidente;
import com.example.springrelationshipsdemo.services.IncidenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "incidentes")
public class IncidentesControlador {

    @Autowired
    private IncidenteServicio servicio;

    @GetMapping
    public List<Incidente> index(){

        return servicio.list();

    }

    @GetMapping("{reporte}")
    public Incidente get(@PathVariable Integer reporte){

        return servicio.find(reporte);

    }

    @PostMapping
    public Incidente post(@RequestBody Incidente incidente){

        return servicio.save(incidente);

    }

    @RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT}, path = "{reporte}")
    public Incidente patch(@RequestBody Incidente incidente, @PathVariable Integer reporte){

        Incidente in_bd = servicio.find(reporte);

        if(in_bd != null){

            in_bd.setFecha(incidente.getFecha());
            in_bd.setLugar(incidente.getLugar());

            return servicio.save(in_bd);

        }

        return null;

    }

    @DeleteMapping("{reporte}")
    public String delete(@PathVariable Integer reporte){

        return switch (servicio.delete(reporte)) {
            case 1 -> "El registro ha sido eliminado";
            case 2 -> "El registro no existe";
            default -> "El registro no ha podido eliminarse debido a un motivo desconocido";
        };

    }

}