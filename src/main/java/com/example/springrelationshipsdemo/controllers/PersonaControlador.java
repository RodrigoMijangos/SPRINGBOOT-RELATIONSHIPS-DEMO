package com.example.springrelationshipsdemo.controllers;

import com.example.springrelationshipsdemo.dao.requests.PersonaRequest;
import com.example.springrelationshipsdemo.entities.Persona;
import com.example.springrelationshipsdemo.services.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personas")
public class PersonaControlador {

    @Autowired
    private PersonaServicio servicio;

    @GetMapping
    public List<Persona> index(){

        return servicio.list();

    }

    @GetMapping("{id}")
    public Persona get(@PathVariable Integer id){

        return servicio.find(id);

    }

    @PostMapping
    public Persona post(@RequestBody PersonaRequest requestBody){

        Persona new_persona = new Persona();

        new_persona.setNombre(requestBody.getNombre());
        new_persona.setDireccion(requestBody.getDireccion());

        return servicio.save(new_persona);

    }

    @RequestMapping(path = "{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public Persona patch(@RequestBody PersonaRequest requestBody, @PathVariable Integer id){

        Persona in_bd = servicio.find(id);

        if(in_bd != null){

            in_bd.setNombre(requestBody.getNombre());
            in_bd.setDireccion(requestBody.getDireccion());

            return servicio.save(in_bd);

        }

        return null;

    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        return switch (servicio.delete(id)) {
            case 1 -> "El registro ha sido eliminado";
            case 2 -> "El registro no existe";
            default -> "El registro no ha podido eliminarse debido a un motivo desconocido";
        };

    }


}