package com.example.springrelationshipsdemo.repositories;

import com.example.springrelationshipsdemo.entities.Carro;
import com.example.springrelationshipsdemo.entities.IncidentesVinculacion;
import com.example.springrelationshipsdemo.entities.IncidentesVinculacionKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IncidentesVinculacionRepositorio extends JpaRepository<IncidentesVinculacion, IncidentesVinculacionKey> {}