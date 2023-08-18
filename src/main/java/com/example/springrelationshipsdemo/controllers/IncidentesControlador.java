package com.example.springrelationshipsdemo.controllers;

import com.example.springrelationshipsdemo.dao.requests.IncidenteRequest;
import com.example.springrelationshipsdemo.dao.requests.ValidacionCarroRequest;
import com.example.springrelationshipsdemo.entities.Carro;
import com.example.springrelationshipsdemo.entities.Incidente;
import com.example.springrelationshipsdemo.services.CarroServicio;
import com.example.springrelationshipsdemo.services.IncidenteServicio;
import com.example.springrelationshipsdemo.services.VinculacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "incidentes")
public class IncidentesControlador {

    @Autowired
    private IncidenteServicio servicio;

    @Autowired
    private CarroServicio carroServicio;

    @Autowired
    private VinculacionServicio vinculacionServicio;

    @GetMapping
    public List<Incidente> index(){

        return servicio.list();

    }

    @GetMapping("{reporte}")
    public Incidente get(@PathVariable Integer reporte){

        return servicio.find(reporte);

    }

    @PostMapping
    public Incidente post(@RequestBody IncidenteRequest incidente){

        Incidente new_incidente = new Incidente();

        new_incidente.setLugar(incidente.getLugar());
        new_incidente.setFecha(incidente.getFecha());

        return servicio.save(new_incidente);

    }

    @RequestMapping(method = {RequestMethod.PATCH, RequestMethod.PUT}, path = "{reporte}")
    public Incidente patch(@RequestBody IncidenteRequest incidente, @PathVariable Integer reporte){

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

    @GetMapping("{reporte}/involucrados")
    public List<Carro> getInvolucrados(@PathVariable Integer reporte){

        return carroServicio.getIncidentes(reporte);

    }

    @PostMapping("{reporte}/nuevo_afectado")
    public Incidente nuevoAfectado(@PathVariable Integer reporte, @RequestBody ValidacionCarroRequest requestBody){

        Incidente in_bd = servicio.find(reporte);

        if(in_bd == null)
            return null;

        Carro carro = carroServicio.find(requestBody.getCarro_id());

        if(carro == null)
            return null;

        in_bd.getCarrosVinculados().add(vinculacionServicio.vincularCarro(in_bd.getReporte(), carro.getId(), requestBody.getCostos()));

        return servicio.save(in_bd);

    }

}