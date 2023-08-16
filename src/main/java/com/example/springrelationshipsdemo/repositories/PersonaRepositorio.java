package com.example.springrelationshipsdemo.repositories;

import com.example.springrelationshipsdemo.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {}