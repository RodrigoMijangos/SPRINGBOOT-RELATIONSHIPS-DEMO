package com.example.springrelationshipsdemo.services;

import com.example.springrelationshipsdemo.entities.Incidente;
import com.example.springrelationshipsdemo.repositories.IncidenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncidenteServicio {

    @Autowired
    private IncidenteRepositorio repositorio;

    public List<Incidente> list(){
        return repositorio.findAll();
    }

    public Incidente find(Integer reporte){

        return repositorio.findById(reporte).orElse(null);

    }

    public Incidente save(Incidente incidente){

        return repositorio.save(incidente);

    }

    public int delete(Integer reporte) {

        Incidente in_bd = repositorio.findById(reporte).orElse(null);

        if(in_bd == null)
            return 2;

        repositorio.delete(in_bd);

        return repositorio.findById(reporte).isPresent() ? 0 : 1;

    }

}