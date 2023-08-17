package com.example.springrelationshipsdemo.repositories;

import com.example.springrelationshipsdemo.entities.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepositorio extends JpaRepository<Carro, Integer> {

    List<Carro> findAllByIncidentesVinculadosIncidenteReporte(Integer reporte);

}