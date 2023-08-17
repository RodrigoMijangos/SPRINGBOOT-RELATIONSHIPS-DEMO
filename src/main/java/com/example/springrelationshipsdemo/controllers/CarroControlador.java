package com.example.springrelationshipsdemo.controllers;

import com.example.springrelationshipsdemo.dao.requests.CarroRequest;
import com.example.springrelationshipsdemo.entities.Carro;
import com.example.springrelationshipsdemo.entities.Persona;
import com.example.springrelationshipsdemo.services.CarroServicio;
import com.example.springrelationshipsdemo.services.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carros")
public class CarroControlador {

    @Autowired
    private CarroServicio servicio;

    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping
    public List<Carro> index(){

        return servicio.list();

    }

    @GetMapping("{id}")
    public Carro get(@PathVariable Integer id){

        return servicio.find(id);

    }

    @PostMapping
    public Carro post(@RequestBody CarroRequest requestBody){

        Carro new_item = new Carro();

        new_item.setModelo(requestBody.getModelo());
        new_item.setMatricula(requestBody.getMatricula());

        Persona persona = personaServicio.find(requestBody.getDuenio_id());

        if(persona == null)
            return null;

        new_item.setDuenio(persona);

        return servicio.save(new_item);

    }

    @RequestMapping(path = "{id}", method = {RequestMethod.PUT, RequestMethod.PATCH})
    public Carro patch(@RequestBody CarroRequest requestBody, @PathVariable Integer id){

        Carro in_bd = servicio.find(id);

        if(in_bd == null)
            return null;

        in_bd.setModelo(requestBody.getModelo());
        in_bd.setMatricula(requestBody.getMatricula());

        Persona persona = personaServicio.find(requestBody.getDuenio_id());

        if (persona == null)
            return null;

        in_bd.setDuenio(persona);

        return servicio.save(in_bd);

    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable Integer id){

        return switch (servicio.delete(id)){
            case 1 -> "El registro ha sido eliminado";
            case 2 -> "El registro no existe";
            default -> "El registro no ha podido ser eliminado por un motivo desconocido";
        };

    }


}