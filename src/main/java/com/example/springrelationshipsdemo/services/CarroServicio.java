package com.example.springrelationshipsdemo.services;

import com.example.springrelationshipsdemo.entities.Carro;
import com.example.springrelationshipsdemo.repositories.CarroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServicio {

    @Autowired
    private CarroRepositorio repositorio;

    public List<Carro> list(){

        return repositorio.findAll();

    }

    public Carro find(Integer id){

        return repositorio.findById(id).orElse(null);

    }

    public Carro save(Carro carro){

        return repositorio.save(carro);

    }

    public int delete(Integer id){

        Carro in_bd = repositorio.findById(id).orElse(null);

        if(in_bd == null)
            return 2;

        repositorio.delete(in_bd);

        return repositorio.findById(id).isPresent() ? 0 : 1;

    }

}