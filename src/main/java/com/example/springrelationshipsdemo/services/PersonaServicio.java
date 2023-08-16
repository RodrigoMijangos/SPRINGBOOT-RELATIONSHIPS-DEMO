package com.example.springrelationshipsdemo.services;

import com.example.springrelationshipsdemo.entities.Persona;
import com.example.springrelationshipsdemo.repositories.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServicio {

    @Autowired
    private PersonaRepositorio repositorio;

    public List<Persona> list(){
        return repositorio.findAll();
    }

    public Persona find(Integer id){

        return repositorio.findById(id).orElse(null);

    }

    public Persona save(Persona persona){

        return repositorio.save(persona);

    }

    public int delete(Integer id){

        Persona in_bd = repositorio.findById(id).orElse(null);

        if(in_bd == null)
            return 2;

        repositorio.delete(in_bd);

        return repositorio.findById(id).isPresent() ? 0 : 1;

    }

}