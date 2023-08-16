package com.example.springrelationshipsdemo.repositories;

import com.example.springrelationshipsdemo.entities.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenteRepositorio extends JpaRepository<Incidente, Integer> {}
