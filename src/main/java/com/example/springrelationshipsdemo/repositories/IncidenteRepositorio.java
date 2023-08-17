package com.example.springrelationshipsdemo.repositories;

import com.example.springrelationshipsdemo.entities.Incidente;
import com.example.springrelationshipsdemo.entities.IncidentesVinculacionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenteRepositorio extends JpaRepository<Incidente, Integer> {

    List<Incidente> findAllByCarrosVinculadosCarroId(Integer id);

}
